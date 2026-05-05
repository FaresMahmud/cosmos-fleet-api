package com.cosmos.fleet.model;

public class NaveRequest {

    private String identificador;
    private String tipo; // "cargueiro", "combate", "exploracao"
    private double combustivelMaximo;
    private double velocidadeBase;

    // atributos extras de cada tipo
    private double capacidadeMaximaCarga; // cargueiro
    private int numeroArmas;              // combate
    private boolean escudoAtivado;        // combate
    private boolean possuiSensoresAvancados; // exploracao

    // Getters e Setters
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getCombustivelMaximo() { return combustivelMaximo; }
    public void setCombustivelMaximo(double combustivelMaximo) { this.combustivelMaximo = combustivelMaximo; }

    public double getVelocidadeBase() { return velocidadeBase; }
    public void setVelocidadeBase(double velocidadeBase) { this.velocidadeBase = velocidadeBase; }

    public double getCapacidadeMaximaCarga() { return capacidadeMaximaCarga; }
    public void setCapacidadeMaximaCarga(double capacidadeMaximaCarga) { this.capacidadeMaximaCarga = capacidadeMaximaCarga; }

    public int getNumeroArmas() { return numeroArmas; }
    public void setNumeroArmas(int numeroArmas) { this.numeroArmas = numeroArmas; }

    public boolean isEscudoAtivado() { return escudoAtivado; }
    public void setEscudoAtivado(boolean escudoAtivado) { this.escudoAtivado = escudoAtivado; }

    public boolean isPossuiSensoresAvancados() { return possuiSensoresAvancados; }
    public void setPossuiSensoresAvancados(boolean possuiSensoresAvancados) { this.possuiSensoresAvancados = possuiSensoresAvancados; }
}