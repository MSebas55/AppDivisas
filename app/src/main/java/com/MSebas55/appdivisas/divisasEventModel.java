package com.MSebas55.appdivisas;

public class divisasEventModel {
    public String eventName;
    public String eventPrecio;
    public String eventCantEuro;
    public String eventCambio;

    public divisasEventModel(String eventName, String eventPrecio, String eventCantEuro) {
        this.eventName = eventName;
        this.eventPrecio = eventPrecio;
        this.eventCantEuro = eventCantEuro;
    }

    public String getDivisaName() {
        return eventName;
    }

    public String getDivisaPrecio() {
        return eventPrecio;
    }

    public String getCantEuro() {
        return eventCantEuro;
    }

    /*public String getCambioDivisa() {
        eventCambio =
        return eventCambio;
    }*/

}