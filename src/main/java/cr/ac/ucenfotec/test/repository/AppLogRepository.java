package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.AppLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppLogRepository extends JpaRepository<AppLog, Long> {
}
