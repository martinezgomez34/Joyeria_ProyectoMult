package com.eduard034.joyeria_proyectomult.models;

public class Joya {
    private int idJoya;
    private String nombreJoya;
    private String cantidadDJoya;
    private String descripcionDJoya;

    public Joya(int idJoya, String nombreJoya, String cantidadDJoya, String descripcionDJoya) {
        this.idJoya = idJoya;
        this.nombreJoya = nombreJoya;
        this.cantidadDJoya = cantidadDJoya;
        this.descripcionDJoya = descripcionDJoya;
    }

    public int getIdJoya() {
        return idJoya;
    }

    public String getNombreJoya() {
        return nombreJoya;
    }

    public String getCantidadDJoya() {
        return cantidadDJoya;
    }

    public String getDescripcionDJoya() {
        return descripcionDJoya;
    }

    public void setDescripcionDJoya(String descripcionDJoya) {
        this.descripcionDJoya = descripcionDJoya;
    }

    public void setCantidadDJoya(String cantidadDJoya) {
        this.cantidadDJoya = cantidadDJoya;
    }

    public void setNombreJoya(String nombreJoya) {
        this.nombreJoya = nombreJoya;
    }

    public void setIdJoya(int idJoya) {
        this.idJoya = idJoya;
    }
}
