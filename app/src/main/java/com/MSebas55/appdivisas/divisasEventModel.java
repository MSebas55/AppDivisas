package com.MSebas55.appdivisas;

public class divisasEventModel {
    public String eventName;
    public String eventPrecio;
    public int eventIcono;

    public divisasEventModel(String eventName, String eventPrecio, int eventIcono) {
        this.eventName = eventName;
        this.eventPrecio = eventPrecio;
        this.eventIcono = eventIcono;
    }

    public String getDivisaName() {
        return eventName;
    }

    public String getDivisaPrecio() {
        return eventPrecio;
    }

    public int getDivisaIcono() {
        return eventIcono;
    }
}
