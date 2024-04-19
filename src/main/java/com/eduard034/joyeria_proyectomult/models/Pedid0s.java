package com.eduard034.joyeria_proyectomult.models;

import java.util.Objects;

public class Pedid0s {
    private int id;
    private String nombrec;
    private int contactoc;
    private int tipoj;
    private String cantidadj;
    private String fechap;
    private String horap;

    public Pedid0s(int id, String nombrec, int contactoc, int tipoj, String cantidadj, String fechap, String horap) {
        this.id = id;
        this.nombrec = nombrec;
        this.contactoc = contactoc;
        this.tipoj = tipoj;
        this.cantidadj = cantidadj;
        this.fechap = fechap;
        this.horap = horap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public int getContactoc() {
        return contactoc;
    }

    public void setContactoc(int contactoc) {
        this.contactoc = contactoc;
    }

    public int getTipoj() {
        return tipoj;
    }

    public void setTipoj(int tipoj) {
        this.tipoj = tipoj;
    }

    public String getCantidadj() {
        return cantidadj;
    }

    public void setCantidadj(String cantidadj) {
        this.cantidadj = cantidadj;
    }

    public String getFechap() {
        return fechap;
    }

    public void setFechap(String fechap) {
        this.fechap = fechap;
    }

    public String getHorap() {
        return horap;
    }

    public void setHorap(String horap) {
        this.horap = horap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedid0s)) return false;
        Pedid0s pedid0s = (Pedid0s) o;
        return getId() == pedid0s.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

