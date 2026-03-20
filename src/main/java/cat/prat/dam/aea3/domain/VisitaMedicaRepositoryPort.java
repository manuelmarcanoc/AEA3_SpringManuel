package cat.prat.dam.aea3.domain;

import java.util.List;
import java.util.Optional;

public interface VisitaMedicaRepositoryPort {
    VisitaMedica save(VisitaMedica visita);
    Optional<VisitaMedica> findById(Integer id);
    List<VisitaMedica> findAll();
    void deleteById(Integer id);
}
