package com.miguelnieves.solarsports.models;

public class TerrazaSolar {
    String tipoTerraza, mes;
    int energiaGenerada, valorAhorrado;

    public TerrazaSolar(String tipoTerraza, int energiaGenerada, int valorAhorrado, String mes) {
        this.tipoTerraza = tipoTerraza;
        this.energiaGenerada = energiaGenerada;
        this.valorAhorrado = valorAhorrado;
        this.mes = mes;
    }

    public String getTerraza() {
        return tipoTerraza;
    }

    public void setTerraza(String tipoTerraza) {
        this.tipoTerraza = tipoTerraza;
    }



    public Integer getEnergia() {
        return energiaGenerada;
    }

    public void setEnergia(int energiaGenerada) {
        this.energiaGenerada = energiaGenerada;
    }



    public int getValorAhorrado() {
        return valorAhorrado;
    }

    public void setValorAhorrado(int username) {
        this.valorAhorrado = valorAhorrado;
    }



    public String getMes() {
        return mes;
    }

    public void setMes (String mes) {
        this.mes = mes;
    }
}
