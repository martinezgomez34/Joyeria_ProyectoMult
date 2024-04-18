package com.eduard034.joyeria_proyectomult.models;

import java.util.ArrayList;

public class Database {
    public ArrayList<Gasto> listaGastos = new ArrayList<>();

    public ArrayList<Gasto> getListaGastos() {
        return listaGastos;
    }

    public boolean setListaGastos(Gasto gasto) {
        return listaGastos.add(gasto);
    }
}
