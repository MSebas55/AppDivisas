package com.MSebas55.appdivisas;

public class divisasEventModel {
    public String eventName;
    public String eventPrecio;
    public int eventIcon;  // Nueva propiedad para la referencia al ícono de la divisa

    public divisasEventModel(String eventName, String eventPrecio, int eventIcon) {
        this.eventName = eventName;
        this.eventPrecio = eventPrecio;
        this.eventIcon = eventIcon;
    }

    public String getDivisaName() {
        return eventName;
    }

    public String getDivisaPrecio() {
        return eventPrecio;
    }

    public int getDivisaIcon() {
        return eventIcon;
    }
}
