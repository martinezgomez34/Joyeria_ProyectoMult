package com.eduard034.joyeria_proyectomult.models;

import java.util.ArrayList;

public class Gasto {
    private int id;
    private String descripcionDGasto;
    private String cantidadDGasto;
    private String fechaDGasto;
    public Gasto(int id, String descripcionDGasto, String cantidadDGasto, String fechaDGasto) {
        this.id = id;
        this.descripcionDGasto = descripcionDGasto;
        this.cantidadDGasto = cantidadDGasto;
        this.fechaDGasto = fechaDGasto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionDGasto() {
        return descripcionDGasto;
    }

    public void setDescripcionDGasto(String descripcionDGasto) {
        this.descripcionDGasto = descripcionDGasto;
    }

    public String getCantidadDGasto() {
        return cantidadDGasto;
    }

    public void setCantidadDGasto(String cantidadDGasto) {
        this.cantidadDGasto = cantidadDGasto;
    }

    public String getFechaDGasto() {
        return fechaDGasto;
    }

    public void setFechaDGasto(String fechaDGasto) {
        this.fechaDGasto = fechaDGasto;
    }
}