package cr.ac.ucenfotec.test.repository;

import cr.ac.ucenfotec.test.domain.PartnerRequest;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PartnerRequest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartnerRequestRepository extends JpaRepository<PartnerRequest, Long> {
}
