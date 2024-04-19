package com.eduard034.joyeria_proyectomult.models;

public class Venta {
    private String nombreDCliente;
    private String fechaDVenta;
    private String totalGanancia;
    private String tipoDJoya;
    private int cantidadDJoya;

    public Venta(String nombreDCliente, String fechaDVenta, String totalGanancia, String tipoDJoya, int cantidadDJoya) {
        this.nombreDCliente = nombreDCliente;
        this.fechaDVenta = fechaDVenta;
        this.totalGanancia = totalGanancia;
        this.tipoDJoya = tipoDJoya;
        this.cantidadDJoya = cantidadDJoya;
    }

    public String getNombreDCliente() {
        return nombreDCliente;
    }

    public String getFechaDVenta() {
        return fechaDVenta;
    }

    public String getTotalGanancia() {
        return totalGanancia;
    }

    public String getTipoDJoya() {
        return tipoDJoya;
    }

    public int getCantidadDJoya() {
        return cantidadDJoya;
    }

    public void setCantidadDJoya(int cantidadDJoya) {
        this.cantidadDJoya = cantidadDJoya;
    }

    public void setTipoDJoya(String tipoDJoya) {
        this.tipoDJoya = tipoDJoya;
    }

    public void setTotalGanancia(String totalGanancia) {
        this.totalGanancia = totalGanancia;
    }

    public void setFechaDVenta(String fechaDVenta) {
        this.fechaDVenta = fechaDVenta;
    }

    public void setNombreDCliente(String nombreDCliente) {
        this.nombreDCliente = nombreDCliente;
    }

}
