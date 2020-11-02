package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.Raffle;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Raffle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RaffleRepository extends JpaRepository<Raffle, Long> {
}
