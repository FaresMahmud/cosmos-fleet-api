package com.cosmos.fleet.service;

import com.cosmos.fleet.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrotaService {

    private List<NaveEspacial> frota = new ArrayList<>();

    public FrotaService() {
        frota.add(new NaveCargueiro("Cargueiro Alpha", 1000, 1000, 50, 500));
        frota.add(new NaveCombate("Destroyer X", 800, 800, 120, 4, true));
        frota.add(new NaveExploracao("Explorer I", 600, 600, 90, true));
    }

    public List<NaveEspacial> listarTodas() {
        return frota;
    }

    public NaveEspacial buscarPorId(String identificador) {
        return frota.stream()
                .filter(n -> n.getIdentificador().equalsIgnoreCase(identificador))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nave não encontrada: " + identificador));
    }

    public void viajar(String identificador, double distancia) {
        NaveEspacial nave = buscarPorId(identificador);
        nave.viajar(distancia);
    }

    public void abastecer(String identificador, double quantidade) {
        NaveEspacial nave = buscarPorId(identificador);
        nave.setCombustivelAtual(nave.getCombustivelAtual() + quantidade);
    }
}