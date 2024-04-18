package com.eduard034.joyeria_proyectomult.models;

import java.util.ArrayList;

public class Database {
    public int getIdbP() {
        return IdbP;
    }

    public void setIdbP(int idbP) {
        IdbP = idbP;
    }

    private int IdbP;
    private ArrayList<Pedid0s>listapedidos = new ArrayList<>();
    public ArrayList<Gasto> listaGastos = new ArrayList<>();

    public ArrayList<Gasto> getListaGastos() {
        return listaGastos;
    }

    public boolean setListaGastos(Gasto gasto) {
        return listaGastos.add(gasto);
    }

    public ArrayList<Pedid0s> getListapedidos() {
        return listapedidos;
    }

    public boolean setListapedidos(Pedid0s pedido){
        return listapedidos.add(pedido);
    }
}
