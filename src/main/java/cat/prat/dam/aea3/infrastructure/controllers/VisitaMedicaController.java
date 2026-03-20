package cat.prat.dam.aea3.infrastructure.controllers;

import cat.prat.dam.aea3.application.VisitaMedicaUseCase;
import cat.prat.dam.aea3.domain.VisitaMedica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visites")
public class VisitaMedicaController {

    private final VisitaMedicaUseCase visitaMedicaUseCase;

    public VisitaMedicaController(VisitaMedicaUseCase visitaMedicaUseCase) {
        this.visitaMedicaUseCase = visitaMedicaUseCase;
    }

    @PostMapping
    public ResponseEntity<VisitaMedica> create(@RequestBody VisitaMedica visitaMedica) {
        VisitaMedica created = visitaMedicaUseCase.createVisita(visitaMedica);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitaMedica> getById(@PathVariable Integer id) {
        return visitaMedicaUseCase.getVisitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VisitaMedica>> getAll() {
        List<VisitaMedica> visites = visitaMedicaUseCase.getAllVisites();
        return ResponseEntity.ok(visites);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitaMedica> update(@PathVariable Integer id, @RequestBody VisitaMedica visitaMedica) {
        try {
            VisitaMedica updated = visitaMedicaUseCase.updateVisita(id, visitaMedica);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        visitaMedicaUseCase.deleteVisita(id);
        return ResponseEntity.noContent().build();
    }
}
