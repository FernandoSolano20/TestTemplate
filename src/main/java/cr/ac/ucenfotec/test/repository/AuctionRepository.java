package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.Auction;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Auction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
