package cat.prat.dam.aea3.application;

import cat.prat.dam.aea3.domain.VisitaMedica;
import cat.prat.dam.aea3.domain.VisitaMedicaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitaMedicaService implements VisitaMedicaUseCase {

    private final VisitaMedicaRepositoryPort repositoryPort;

    public VisitaMedicaService(VisitaMedicaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public VisitaMedica createVisita(VisitaMedica visita) {
        return repositoryPort.save(visita);
    }

    @Override
    public Optional<VisitaMedica> getVisitaById(Integer id) {
        return repositoryPort.findById(id);
    }

    @Override
    public List<VisitaMedica> getAllVisites() {
        return repositoryPort.findAll();
    }

    @Override
    public VisitaMedica updateVisita(Integer id, VisitaMedica visitaDetails) {
        return repositoryPort.findById(id)
            .map(existingVisita -> {
                existingVisita.setNomPacient(visitaDetails.getNomPacient());
                existingVisita.setNomMetge(visitaDetails.getNomMetge());
                existingVisita.setData(visitaDetails.getData());
                existingVisita.setDiagnostic(visitaDetails.getDiagnostic());
                return repositoryPort.save(existingVisita);
            }).orElseThrow(() -> new RuntimeException("Visita no trobada amb id: " + id));
    }

    @Override
    public void deleteVisita(Integer id) {
        repositoryPort.deleteById(id);
    }
}
