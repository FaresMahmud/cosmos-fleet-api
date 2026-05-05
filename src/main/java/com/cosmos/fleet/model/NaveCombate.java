package com.cosmos.fleet.model;

public class NaveCombate extends NaveEspacial {

    private int numeroArmas;
    private boolean escudoAtivado;

    public NaveCombate(String identificador, double combustivelMaximo,
                       double velocidadeBase, int numeroArmas, boolean escudoAtivado) {
        super(identificador, combustivelMaximo, velocidadeBase);
        this.numeroArmas = numeroArmas;
        this.escudoAtivado = escudoAtivado;
    }

    // --- Getters e Setters ---
    public int getNumeroArmas() { return numeroArmas; }
    public boolean isEscudoAtivado() { return escudoAtivado; }
    public void setEscudoAtivado(boolean escudoAtivado) { this.escudoAtivado = escudoAtivado; }

    // --- Fórmula de consumo da nave de combate ---
    @Override
    public double calcularConsumo(double distancia) {
        double consumo = distancia * 0.8;

        // se o escudo estiver ligado, consome 15% a mais
        if (escudoAtivado) {
            consumo = consumo * 1.15;
        }

        return consumo;
    }
}