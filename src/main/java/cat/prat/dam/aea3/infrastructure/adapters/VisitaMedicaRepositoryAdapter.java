package cat.prat.dam.aea3.infrastructure.adapters;

import cat.prat.dam.aea3.domain.VisitaMedica;
import cat.prat.dam.aea3.domain.VisitaMedicaRepositoryPort;
import cat.prat.dam.aea3.infrastructure.entities.VisitaMedicaEntity;
import cat.prat.dam.aea3.infrastructure.repositories.VisitaMedicaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VisitaMedicaRepositoryAdapter implements VisitaMedicaRepositoryPort {

    private final VisitaMedicaJpaRepository jpaRepository;

    public VisitaMedicaRepositoryAdapter(VisitaMedicaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public VisitaMedica save(VisitaMedica visita) {
        VisitaMedicaEntity entity = VisitaMedicaEntity.fromDomain(visita);
        VisitaMedicaEntity savedEntity = jpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<VisitaMedica> findById(Integer id) {
        return jpaRepository.findById(id).map(VisitaMedicaEntity::toDomain);
    }

    @Override
    public List<VisitaMedica> findAll() {
        return jpaRepository.findAll().stream()
                .map(VisitaMedicaEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
