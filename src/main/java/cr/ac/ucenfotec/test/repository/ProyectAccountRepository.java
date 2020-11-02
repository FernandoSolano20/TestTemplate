package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.ProyectAccount;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProyectAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProyectAccountRepository extends JpaRepository<ProyectAccount, Long> {
}
