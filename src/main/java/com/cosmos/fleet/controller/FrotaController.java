package com.cosmos.fleet.controller;

import com.cosmos.fleet.model.*;
import com.cosmos.fleet.service.FrotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/naves")
public class FrotaController {

    private final FrotaService frotaService;

    public FrotaController(FrotaService frotaService) {
        this.frotaService = frotaService;
    }

    // GET /naves
    @GetMapping
    public ResponseEntity<List<NaveEspacial>> listarTodas() {
        return ResponseEntity.ok(frotaService.listarTodas());
    }

    // GET /naves/{identificador}
    @GetMapping("/{identificador}")
    public ResponseEntity<NaveEspacial> buscarPorId(@PathVariable String identificador) {
        return ResponseEntity.ok(frotaService.buscarPorId(identificador));
    }

    // POST /naves → cria uma nave nova
    @PostMapping
    public ResponseEntity<NaveEspacial> criarNave(@RequestBody NaveRequest req) {
        return ResponseEntity.ok(frotaService.criarNave(req));
    }

    // DELETE /naves/{identificador} → deleta uma nave
    @DeleteMapping("/{identificador}")
    public ResponseEntity<String> deletarNave(@PathVariable String identificador) {
        frotaService.deletarNave(identificador);
        return ResponseEntity.ok("Nave " + identificador + " removida da frota.");
    }

    // POST /naves/{identificador}/viajar?distancia=1000
    @PostMapping("/{identificador}/viajar")
    public ResponseEntity<String> viajar(@PathVariable String identificador,
                                         @RequestParam double distancia) {
        frotaService.viajar(identificador, distancia);
        return ResponseEntity.ok("Viagem realizada com sucesso!");
    }

    // PATCH /naves/{identificador}/abastecer?quantidade=200
    @PatchMapping("/{identificador}/abastecer")
    public ResponseEntity<String> abastecer(@PathVariable String identificador,
                                            @RequestParam double quantidade) {
        frotaService.abastecer(identificador, quantidade);
        return ResponseEntity.ok("Nave abastecida com sucesso!");
    }

    // GET /naves/historico → histórico geral
    @GetMapping("/historico")
    public ResponseEntity<List<ViagemRecord>> historicoGeral() {
        return ResponseEntity.ok(frotaService.historicoGeral());
    }

    // GET /naves/{identificador}/historico → histórico de uma nave
    @GetMapping("/{identificador}/historico")
    public ResponseEntity<List<ViagemRecord>> historicoPorNave(@PathVariable String identificador) {
        return ResponseEntity.ok(frotaService.historicoPorNave(identificador));
    }
}