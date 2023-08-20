package com.miguelnieves.solarsports.models;

public class TerrazaSolar {
    String tipoTerraza, mes;
    double energiaGenerada, valorAhorrado;

    public TerrazaSolar(String tipoTerraza, double energiaGenerada, double valorAhorrado, String mes) {
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



    public Double getEnergia() {
        return energiaGenerada;
    }

    public void setEnergia(double energiaGenerada) {
        this.energiaGenerada = energiaGenerada;
    }



    public double getValorAhorrado() {
        return valorAhorrado;
    }

    public void setValorAhorrado(double valorAhorrado) {
        this.valorAhorrado = valorAhorrado;
    }



    public String getMes() {
        return mes;
    }

    public void setMes (String mes) {
        this.mes = mes;
    }
}
