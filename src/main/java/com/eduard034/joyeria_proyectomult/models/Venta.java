package com.eduard034.joyeria_proyectomult.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta)) return false;
        Venta venta = (Venta) o;
        return Objects.equals(getNombreDCliente(), venta.getNombreDCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreDCliente());
    }
}
