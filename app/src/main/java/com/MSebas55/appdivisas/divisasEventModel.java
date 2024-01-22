package com.MSebas55.appdivisas;

public class divisasEventModel {
    public String eventName;
    public String eventPrecio;

    public divisasEventModel(String eventName, String eventPrecio) {
        this.eventName = eventName;
        this.eventPrecio = eventPrecio;
    }

    public String getDivisaName() {
        return eventName;
    }

    public String getDivisaPrecio() {
        return eventPrecio;
    }

}