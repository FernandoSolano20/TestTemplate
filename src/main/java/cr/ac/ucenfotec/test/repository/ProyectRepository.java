package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.Proyect;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Proyect entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Long> {
}
