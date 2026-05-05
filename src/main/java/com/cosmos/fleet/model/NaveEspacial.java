package com.cosmos.fleet.model;

import com.cosmos.fleet.exception.CombustivelInsuficienteException;
import com.cosmos.fleet.exception.CombustivelInvalidoException;

public abstract class NaveEspacial {
    private String identificador;
    private double combustivelMaximo;
    private double combustivelAtual;
    private double velocidadeBase;

    public NaveEspacial(String identificador, double combustivelMaximo, double combustivelAtual, double velocidadeBase) {
        this.identificador = identificador;
        this.combustivelMaximo = combustivelMaximo;
        this.combustivelAtual = combustivelAtual;
        this.velocidadeBase = velocidadeBase;
    }

    //GETTERS
    public String getIdentificador() {
        return identificador;
    }

    public double getCombustivelMaximo() {
        return combustivelMaximo;
    }

    public double getCombustivelAtual() {
        return combustivelAtual;
    }

    public double getVelocidadeBase() {
        return velocidadeBase;
    }

    public void setCombustivelAtual(double valorCombustivelAtual) {
        if (valorCombustivelAtual < 0 || valorCombustivelAtual > combustivelMaximo) {
            throw new CombustivelInvalidoException("Valor do combustivel inválido");
        }
        this.combustivelAtual = valorCombustivelAtual;
    }

    //método abstrato
    public abstract double calcularConsumo(double distancia);

    // Método concreto de viajar
    public void viajar(double distancia) {
        double consumo = calcularConsumo(distancia);

        if (combustivelAtual < consumo) {
            throw new CombustivelInsuficienteException(
                    "Combustível insuficiente! Necessário: " + consumo +
                            " | Disponível: " + combustivelAtual
            );
        }
        setCombustivelAtual(combustivelAtual - consumo);
        System.out.println("A nave " + identificador + " viajou " + distancia +
                " anos-luz. Combustível restante: " + combustivelAtual);
    }
}
