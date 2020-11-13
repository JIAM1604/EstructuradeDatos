package sample;

import javafx.fxml.FXML;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
        import javafx.scene.control.ListView;
        import javafx.scene.control.TextField;

public class Controller {

        @FXML TextField textField;
        @FXML ListView lista;
        @FXML ComboBox combo;

        @FXML
        public void initialize(){
                combo.getItems().addAll("Carpa","Salmon","Arenque","Magikarp","Trucha","Piraña");
                combo.getSelectionModel().select(0);
        }
        Pez pesca = new Pez();
        String[] pescados= new String[3];
       
        public void insertar(ActionEvent event){
                if(textField.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Rellena todos los campos");
                        alert.setHeaderText("--Alerta--");
                        alert.showAndWait();

                }else{
                        double dato= Double.parseDouble(textField.getText());
                        double reto= (dato*.10);
                        String Resto= String.valueOf(dato);
                        String res= pesca.por_nacimiento(dato);

                        pescados [0]=res;
                        pescados [1]= String.valueOf(combo.getValue().toString());
                        pescados [3]=Resto;

                }
        }
        public void procesar(ActionEvent event){
        double dato= Double.parseDouble(textField.getText());
        lista.getItems().add("Pescado"+ pescados [1]+"nacen"+dato+"por cria");
        }


}

