package com.cosmos.fleet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViagemRecord {

    private String naveIdentificador;
    private double distancia;
    private double combustivelConsumido;
    private String dataHora;

    public ViagemRecord(String naveIdentificador, double distancia, double combustivelConsumido) {
        this.naveIdentificador = naveIdentificador;
        this.distancia = distancia;
        this.combustivelConsumido = combustivelConsumido;
        this.dataHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getNaveIdentificador() { return naveIdentificador; }
    public double getDistancia() { return distancia; }
    public double getCombustivelConsumido() { return combustivelConsumido; }
    public String getDataHora() { return dataHora; }
}