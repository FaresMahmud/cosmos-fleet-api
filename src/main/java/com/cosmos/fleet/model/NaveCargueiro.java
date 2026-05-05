package com.cosmos.fleet.model;

public class NaveCargueiro extends NaveEspacial {

    private double pesoCargaAtual;
    private double capacidadeMaximaCarga;

    public NaveCargueiro(String identificador, double combustivelMaximo,
                         double velocidadeBase, double capacidadeMaximaCarga) {
        super(identificador, combustivelMaximo, combustivelMaximo, velocidadeBase);
        this.capacidadeMaximaCarga = capacidadeMaximaCarga;
        this.pesoCargaAtual = 0;
    }

    // --- Getters e Setter com validação ---
    public double getPesoCargaAtual() { return pesoCargaAtual; }
    public double getCapacidadeMaximaCarga() { return capacidadeMaximaCarga; }

    public void setPesoCargaAtual(double peso) {
        if (peso > capacidadeMaximaCarga) {
            throw new IllegalArgumentException("Peso excede a capacidade máxima da carga!");
        }
        this.pesoCargaAtual = peso;
    }

    // --- Fórmula de consumo do cargueiro ---
    @Override
    public double calcularConsumo(double distancia) {
        return (distancia * 0.5) + (pesoCargaAtual * 0.2);
    }
}
