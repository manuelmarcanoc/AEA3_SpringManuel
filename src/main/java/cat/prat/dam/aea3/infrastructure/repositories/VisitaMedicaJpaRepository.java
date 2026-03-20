package cat.prat.dam.aea3.infrastructure.repositories;

import cat.prat.dam.aea3.infrastructure.entities.VisitaMedicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaMedicaJpaRepository extends JpaRepository<VisitaMedicaEntity, Integer> {
}
