package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Estaciones {
    private SimpleIntegerProperty idestacion;
    private SimpleStringProperty consola;
    private SimpleStringProperty videojuego;
    private SimpleStringProperty cliente;
    private SimpleStringProperty tiempo;
    private SimpleIntegerProperty precioxmin;

    public Estaciones(int idestacion, String consola, String videojuego, String cliente, String tiempo, int precioxmin) {
        this.idestacion = new SimpleIntegerProperty(idestacion);
        this.consola = new SimpleStringProperty(consola);
        this.videojuego = new SimpleStringProperty(videojuego);
        this.cliente = new SimpleStringProperty(cliente);
        this.tiempo = new SimpleStringProperty(tiempo);
        this.precioxmin = new SimpleIntegerProperty(precioxmin);
    }

    public int getIdestacion() {
        return idestacion.get();
    }

    public SimpleIntegerProperty idestacionProperty() {
        return idestacion;
    }

    public void setIdestacion(int idestacion) {
        this.idestacion.set(idestacion);
    }

    public String getConsola() {
        return consola.get();
    }

    public SimpleStringProperty consolaProperty() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola.set(consola);
    }

    public String getVideojuego() {
        return videojuego.get();
    }

    public SimpleStringProperty videojuegoProperty() {
        return videojuego;
    }

    public void setVideojuego(String videojuego) {
        this.videojuego.set(videojuego);
    }

    public String getCliente() {
        return cliente.get();
    }

    public SimpleStringProperty clienteProperty() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente.set(cliente);
    }

    public String getTiempo() {
        return tiempo.get();
    }

    public SimpleStringProperty tiempoProperty() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo.set(tiempo);
    }

    public int getPrecioxmin() {
        return precioxmin.get();
    }

    public SimpleIntegerProperty precioxminProperty() {
        return precioxmin;
    }

    public void setPrecioxmin(int precioxmin) {
        this.precioxmin.set(precioxmin);
    }
}
