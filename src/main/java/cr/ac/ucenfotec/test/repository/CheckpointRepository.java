package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.Checkpoint;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Checkpoint entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
}
