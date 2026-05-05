package com.cosmos.fleet.model;

public class NaveExploracao extends NaveEspacial {

    private boolean possuiSensoresAvancados;

    public NaveExploracao(String identificador, double combustivelMaximo,
                          double combustivelAtual, double velocidadeBase,
                          boolean possuiSensoresAvancados) {
        super(identificador, combustivelMaximo, combustivelAtual, velocidadeBase);
        this.possuiSensoresAvancados = possuiSensoresAvancados;
    }

    public boolean isPossuiSensoresAvancados() { return possuiSensoresAvancados; }
    public void setPossuiSensoresAvancados(boolean v) { this.possuiSensoresAvancados = v; }

    @Override
    public double calcularConsumo(double distancia) {
        double consumo = distancia * 0.3;
        if (possuiSensoresAvancados) {
            consumo = consumo + 50.0;
        }
        return consumo;
    }
}