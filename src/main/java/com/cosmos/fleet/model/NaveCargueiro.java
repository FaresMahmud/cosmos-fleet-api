package com.cosmos.fleet.model;

public class NaveCargueiro extends NaveEspacial {

    private double pesoCargaAtual;
    private double capacidadeMaximaCarga;

    public NaveCargueiro(String identificador, double combustivelMaximo,
                         double combustivelAtual, double velocidadeBase,
                         double capacidadeMaximaCarga) {
        super(identificador, combustivelMaximo, combustivelAtual, velocidadeBase);
        this.capacidadeMaximaCarga = capacidadeMaximaCarga;
        this.pesoCargaAtual = 0;
    }

    public double getPesoCargaAtual() { return pesoCargaAtual; }
    public double getCapacidadeMaximaCarga() { return capacidadeMaximaCarga; }

    public void setPesoCargaAtual(double peso) {
        if (peso > capacidadeMaximaCarga) {
            throw new IllegalArgumentException("Peso excede a capacidade máxima da carga!");
        }
        this.pesoCargaAtual = peso;
    }

    @Override
    public double calcularConsumo(double distancia) {
        return (distancia * 0.5) + (pesoCargaAtual * 0.2);
    }
}