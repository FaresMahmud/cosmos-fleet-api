package com.cosmos.fleet.controller;

import com.cosmos.fleet.model.NaveEspacial;
import com.cosmos.fleet.service.FrotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // diz pro Spring que essa classe responde requisições HTTP
@RequestMapping("/naves") // todas as rotas começam com /naves
public class FrotaController {

    private final FrotaService frotaService;

    // o Spring injeta o FrotaService automaticamente aqui
    public FrotaController(FrotaService frotaService) {
        this.frotaService = frotaService;
    }

    // GET /naves → lista todas as naves
    @GetMapping
    public ResponseEntity<List<NaveEspacial>> listarTodas() {
        return ResponseEntity.ok(frotaService.listarTodas());
    }

    // GET /naves/{identificador} → detalhes de uma nave
    @GetMapping("/{identificador}")
    public ResponseEntity<NaveEspacial> buscarPorId(@PathVariable String identificador) {
        return ResponseEntity.ok(frotaService.buscarPorId(identificador));
    }

    // POST /naves/{identificador}/viajar?distancia=1000 → manda a nave viajar
    @PostMapping("/{identificador}/viajar")
    public ResponseEntity<String> viajar(@PathVariable String identificador,
                                         @RequestParam double distancia) {
        frotaService.viajar(identificador, distancia);
        return ResponseEntity.ok("Viagem realizada com sucesso!");
    }

    // PATCH /naves/{identificador}/abastecer?quantidade=200 → abastece a nave
    @PatchMapping("/{identificador}/abastecer")
    public ResponseEntity<String> abastecer(@PathVariable String identificador,
                                            @RequestParam double quantidade) {
        frotaService.abastecer(identificador, quantidade);
        return ResponseEntity.ok("Nave abastecida com sucesso!");
    }
}