package cat.prat.dam.aea3.application;

import cat.prat.dam.aea3.domain.VisitaMedica;
import java.util.List;
import java.util.Optional;

public interface VisitaMedicaUseCase {
    VisitaMedica createVisita(VisitaMedica visita);
    Optional<VisitaMedica> getVisitaById(Integer id);
    List<VisitaMedica> getAllVisites();
    VisitaMedica updateVisita(Integer id, VisitaMedica visitaDetails);
    void deleteVisita(Integer id);
}
