package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Controller {
    @FXML TableView tablaestaciones;
    TableColumn idestacion=new TableColumn("ESTACIÓN");
    TableColumn consola=new TableColumn("CONSOLA");
    TableColumn videojuego=new TableColumn("VIDEOJUEGO");
    TableColumn nombrecliente=new TableColumn("CLIENTE");
    TableColumn tiempo=new TableColumn("TIEMPO");
    TableColumn precioxmin=new TableColumn("PRECIO POR MINUTO");

    @FXML ListView<Integer> listaocupadas,listadisponibles;
    @FXML ComboBox consolas,videojuegos;
    @FXML TextField clienteregistro,textototal;
    Queue<Integer> ocupadas= new LinkedList<>();
    Stack<Integer> disponibles= new Stack<>();
    ObservableList<Integer> ld= FXCollections.observableArrayList(disponibles);
    ObservableList<Integer> lo= FXCollections.observableArrayList(ocupadas);
    ObservableList<Estaciones> estaciones= FXCollections.observableArrayList();
    LinkedList<String> listaconsola = new LinkedList<>();
    LinkedList<String> listavideojuegos = new LinkedList<>();

    int contadorestacion=1;
    int total=0;


    @FXML
    public void initialize(){
        listadisponibles.setItems(ld);
        listaocupadas.setItems(lo);
        textototal.setText(total+"");
        idestacion.setCellValueFactory(new PropertyValueFactory<Estaciones,Integer>("idestacion"));
        consola.setCellValueFactory(new PropertyValueFactory<Estaciones,String>("consola"));
        videojuego.setCellValueFactory(new PropertyValueFactory<Estaciones,String>("videojuego"));
        nombrecliente.setCellValueFactory(new PropertyValueFactory<Estaciones,String>("cliente"));
        tiempo.setCellValueFactory(new PropertyValueFactory<Estaciones,String>("tiempo"));
        precioxmin.setCellValueFactory(new PropertyValueFactory<Estaciones,Integer>("precioxmin"));
        tablaestaciones.getColumns().addAll(idestacion,consola,videojuego,nombrecliente,tiempo,precioxmin);
        tablaestaciones.setItems(estaciones);

        listaconsola.add("XBOX ONE");
        listaconsola.add("XBOX X");
        listaconsola.add("XBOX 360");
        listaconsola.add("PS1");
        listaconsola.add("PS2");
        listaconsola.add("PS3");
        listaconsola.add("PS4");
        listaconsola.add("PS5");
        listaconsola.add("WII");
        listaconsola.add("WII U");
        listaconsola.add("SWITCH");
        for(int i=0;i<listaconsola.size();i++){
            consolas.getItems().addAll(listaconsola.get(i));
        }

        listavideojuegos.add("NEED FOR SPEED");
        listavideojuegos.add("FORNITE");
        listavideojuegos.add("MINECRAFT");
        listavideojuegos.add("HALO");
        listavideojuegos.add("CALL OF DUTY");
        listavideojuegos.add("LEFT 4 DEAD");
        listavideojuegos.add("POKEMON");
        listavideojuegos.add("GEARS OF WAR");
        listavideojuegos.add("SONIC");
        listavideojuegos.add("MARIO");
        listavideojuegos.add("PUBG");
        for(int i=0;i<listavideojuegos.size();i++){
            videojuegos.getItems().addAll(listavideojuegos.get(i));
        }
    }
    public void agregarestacion(){
        disponibles.add(contadorestacion);
        contadorestacion++;
        ld.clear();
        ld.setAll(disponibles);
    }
    public void estacionenuso(){
        if(disponibles.isEmpty()==false){
            ocupadas.add(disponibles.peek());
            int idestacion=disponibles.pop();
            String consola=String.valueOf(consolas.getSelectionModel().getSelectedItem());
            String videojuego=String.valueOf(videojuegos.getSelectionModel().getSelectedItem());;
            String cliente=clienteregistro.getText();
            String tiempo="30min";
            int precio=1;
            estaciones.add(new Estaciones(idestacion,consola,videojuego,cliente,tiempo,precio));
            ld.clear();
            lo.clear();
            ld.setAll(disponibles);
            lo.setAll(ocupadas);
        }
    }
    public void desocuparestacion(){
        if(ocupadas.isEmpty()==false){
            for(int i=0;i<estaciones.size();i++){
                if(ocupadas.peek()==estaciones.get(i).getIdestacion()){
                    estaciones.remove(i);
                    disponibles.add(ocupadas.poll());
                    ld.clear();
                    lo.clear();
                    ld.setAll(disponibles);
                    lo.setAll(ocupadas);
                    total=total+30;
                    textototal.setText("$"+total+"");
                }
            }
        }
    }
    public void ordenarconsola(){
        int i, x;
        for(i=0;i<estaciones.size()-1;i++){
            for(x=0;x<estaciones.size()-i-1;x++){
                if(estaciones.get(x+1).getConsola().compareToIgnoreCase(estaciones.get(x).getConsola())<0){
                    Estaciones estacionesx=estaciones.get(x+1);
                    estaciones.set(x+1,estaciones.get(x));
                    estaciones.set(x,estacionesx);
                }
            }
        }
    }
    public void ordenarjuego(){
        int i, x;
        for(i=0;i<estaciones.size()-1;i++){
            for(x=0;x<estaciones.size()-i-1;x++){
                if(estaciones.get(x+1).getVideojuego().compareToIgnoreCase(estaciones.get(x).getVideojuego())<0){
                    Estaciones estacionesx=estaciones.get(x+1);
                    estaciones.set(x+1,estaciones.get(x));
                    estaciones.set(x,estacionesx);
                }
            }
        }
    }
    public void ordenarnombre(){
        int intervalo, i, j, k;
        int n= estaciones.size();
        intervalo = n / 2;
        while (intervalo > 0)
        {
            for (i = intervalo; i < n; i++)
            {
                j = i - intervalo;
                while (j >= 0)
                {
                    k = j + intervalo;
                    if (estaciones.get(j).getCliente().compareToIgnoreCase(estaciones.get(k).getCliente())<=-1)
                        j = -1; // par de elementos ordenado
                    else
                    {
                        Estaciones estacionesx=estaciones.get(j+1);
                        estaciones.set(j+1,estaciones.get(j));
                        estaciones.set(j,estacionesx);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
    }
    public void ordenarestacion(){
        int intervalo, i, j, k;
        int n= estaciones.size();
        intervalo = n / 2;
        while (intervalo > 0)
        {
            for (i = intervalo; i < n; i++)
            {
                j = i - intervalo;
                while (j >= 0)
                {
                    k = j + intervalo;
                    if (estaciones.get(j).getIdestacion()<= estaciones.get(k).getIdestacion())
                        j = -1; // par de elementos ordenado
                    else
                    {
                        Estaciones estacionesx=estaciones.get(j+1);
                        estaciones.set(j+1,estaciones.get(j));
                        estaciones.set(j,estacionesx);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
    }
}
