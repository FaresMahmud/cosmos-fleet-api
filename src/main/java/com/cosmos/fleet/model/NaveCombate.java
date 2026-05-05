package com.cosmos.fleet.model;

public class NaveCombate extends NaveEspacial {

    private int numeroArmas;
    private boolean escudoAtivado;

    public NaveCombate(String identificador, double combustivelMaximo,
                       double combustivelAtual, double velocidadeBase,
                       int numeroArmas, boolean escudoAtivado) {
        super(identificador, combustivelMaximo, combustivelAtual, velocidadeBase);
        this.numeroArmas = numeroArmas;
        this.escudoAtivado = escudoAtivado;
    }

    public int getNumeroArmas() { return numeroArmas; }
    public boolean isEscudoAtivado() { return escudoAtivado; }
    public void setEscudoAtivado(boolean escudoAtivado) { this.escudoAtivado = escudoAtivado; }

    @Override
    public double calcularConsumo(double distancia) {
        double consumo = distancia * 0.8;
        if (escudoAtivado) {
            consumo = consumo * 1.15;
        }
        return consumo;
    }
}