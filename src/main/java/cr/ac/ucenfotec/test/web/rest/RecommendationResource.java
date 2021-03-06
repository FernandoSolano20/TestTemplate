package cr.ac.ucenfotec.test.web.rest;

import cr.ac.ucenfotec.test.domain.Recommendation;
import cr.ac.ucenfotec.test.repository.RecommendationRepository;
import cr.ac.ucenfotec.test.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link cr.ac.ucenfotec.test.domain.Recommendation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class RecommendationResource {

    private final Logger log = LoggerFactory.getLogger(RecommendationResource.class);

    private static final String ENTITY_NAME = "recommendation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RecommendationRepository recommendationRepository;

    public RecommendationResource(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    /**
     * {@code POST  /recommendations} : Create a new recommendation.
     *
     * @param recommendation the recommendation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new recommendation, or with status {@code 400 (Bad Request)} if the recommendation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/recommendations")
    public ResponseEntity<Recommendation> createRecommendation(@Valid @RequestBody Recommendation recommendation) throws URISyntaxException {
        log.debug("REST request to save Recommendation : {}", recommendation);
        if (recommendation.getId() != null) {
            throw new BadRequestAlertException("A new recommendation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Recommendation result = recommendationRepository.save(recommendation);
        return ResponseEntity.created(new URI("/api/recommendations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /recommendations} : Updates an existing recommendation.
     *
     * @param recommendation the recommendation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated recommendation,
     * or with status {@code 400 (Bad Request)} if the recommendation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the recommendation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/recommendations")
    public ResponseEntity<Recommendation> updateRecommendation(@Valid @RequestBody Recommendation recommendation) throws URISyntaxException {
        log.debug("REST request to update Recommendation : {}", recommendation);
        if (recommendation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Recommendation result = recommendationRepository.save(recommendation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, recommendation.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /recommendations} : get all the recommendations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of recommendations in body.
     */
    @GetMapping("/recommendations")
    public List<Recommendation> getAllRecommendations() {
        log.debug("REST request to get all Recommendations");
        return recommendationRepository.findAll();
    }

    /**
     * {@code GET  /recommendations/:id} : get the "id" recommendation.
     *
     * @param id the id of the recommendation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the recommendation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/recommendations/{id}")
    public ResponseEntity<Recommendation> getRecommendation(@PathVariable Long id) {
        log.debug("REST request to get Recommendation : {}", id);
        Optional<Recommendation> recommendation = recommendationRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(recommendation);
    }

    /**
     * {@code DELETE  /recommendations/:id} : delete the "id" recommendation.
     *
     * @param id the id of the recommendation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/recommendations/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
        log.debug("REST request to delete Recommendation : {}", id);
        recommendationRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
