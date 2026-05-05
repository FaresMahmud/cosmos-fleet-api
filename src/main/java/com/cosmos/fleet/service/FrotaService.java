package com.cosmos.fleet.service;

import com.cosmos.fleet.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrotaService {

    private List<NaveEspacial> frota = new ArrayList<>();
    private List<ViagemRecord> historico = new ArrayList<>();

    public FrotaService() {
        frota.add(new NaveCargueiro("Cargueiro Alpha", 1000, 1000, 50, 500));
        frota.add(new NaveCombate("Destroyer X", 800, 800, 120, 4, true));
        frota.add(new NaveExploracao("Explorer I", 600, 600, 90, true));
    }

    // ── LISTAR ──────────────────────────────────────
    public List<NaveEspacial> listarTodas() {
        return frota;
    }

    public NaveEspacial buscarPorId(String identificador) {
        return frota.stream()
                .filter(n -> n.getIdentificador().equalsIgnoreCase(identificador))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nave não encontrada: " + identificador));
    }

    // ── CRIAR ────────────────────────────────────────
    public NaveEspacial criarNave(NaveRequest req) {
        // verifica se já existe uma nave com esse nome
        boolean jaExiste = frota.stream()
                .anyMatch(n -> n.getIdentificador().equalsIgnoreCase(req.getIdentificador()));
        if (jaExiste) {
            throw new RuntimeException("Já existe uma nave com esse identificador!");
        }

        NaveEspacial nova = switch (req.getTipo().toLowerCase()) {
            case "cargueiro" -> new NaveCargueiro(
                    req.getIdentificador(),
                    req.getCombustivelMaximo(),
                    req.getCombustivelMaximo(),
                    req.getVelocidadeBase(),
                    req.getCapacidadeMaximaCarga()
            );
            case "combate" -> new NaveCombate(
                    req.getIdentificador(),
                    req.getCombustivelMaximo(),
                    req.getCombustivelMaximo(),
                    req.getVelocidadeBase(),
                    req.getNumeroArmas(),
                    req.isEscudoAtivado()
            );
            case "exploracao" -> new NaveExploracao(
                    req.getIdentificador(),
                    req.getCombustivelMaximo(),
                    req.getCombustivelMaximo(),
                    req.getVelocidadeBase(),
                    req.isPossuiSensoresAvancados()
            );
            default -> throw new RuntimeException("Tipo de nave inválido: " + req.getTipo());
        };

        frota.add(nova);
        return nova;
    }

    // ── DELETAR ──────────────────────────────────────
    public void deletarNave(String identificador) {
        NaveEspacial nave = buscarPorId(identificador);
        frota.remove(nave);
    }

    // ── VIAJAR ───────────────────────────────────────
    public void viajar(String identificador, double distancia) {
        NaveEspacial nave = buscarPorId(identificador);
        double combustivelAntes = nave.getCombustivelAtual();
        nave.viajar(distancia);
        double consumido = combustivelAntes - nave.getCombustivelAtual();
        historico.add(new ViagemRecord(identificador, distancia, consumido));
    }

    // ── ABASTECER ────────────────────────────────────
    public void abastecer(String identificador, double quantidade) {
        NaveEspacial nave = buscarPorId(identificador);
        nave.setCombustivelAtual(nave.getCombustivelAtual() + quantidade);
    }

    // ── HISTÓRICO ────────────────────────────────────
    public List<ViagemRecord> historicoGeral() {
        return historico;
    }

    public List<ViagemRecord> historicoPorNave(String identificador) {
        return historico.stream()
                .filter(v -> v.getNaveIdentificador().equalsIgnoreCase(identificador))
                .toList();
    }
}