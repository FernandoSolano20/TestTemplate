package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.PasswordHistory;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PasswordHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {
}
