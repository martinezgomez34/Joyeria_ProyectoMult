package com.eduard034.joyeria_proyectomult.models;

import java.util.ArrayList;

public class Database {
    public int IdBusqueda;
    public ArrayList<Gasto> listaGastos = new ArrayList<>();
    public ArrayList<Joya> listaJoya = new ArrayList<>();
    public ArrayList<Venta> listaVenta = new ArrayList<>();

    public ArrayList<Gasto> getListaGastos() {
        return listaGastos;
    }

    public boolean setListaGastos(Gasto gasto) {
        return listaGastos.add(gasto);
    }

    public ArrayList<Joya> getListaJoya() {
        return listaJoya;
    }

    public boolean setListaJoya(Joya joya) {
        return  listaJoya.add(joya);
    }

    public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }
    public boolean setListaVenta(Venta venta) {
        return  listaVenta.add(venta);
    }
    public int getIdBusqueda() {
        return IdBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        IdBusqueda = idBusqueda;
    }
}
