package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.AdminPreferences;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AdminPreferences entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdminPreferencesRepository extends JpaRepository<AdminPreferences, Long> {
}
