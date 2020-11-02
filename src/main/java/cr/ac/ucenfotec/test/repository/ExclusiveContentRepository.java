package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.ExclusiveContent;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ExclusiveContent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExclusiveContentRepository extends JpaRepository<ExclusiveContent, Long> {
}
