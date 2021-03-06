package cr.ac.ucenfotec.test.web.rest;

import cr.ac.ucenfotec.test.domain.ExclusiveContent;
import cr.ac.ucenfotec.test.repository.ExclusiveContentRepository;
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
 * REST controller for managing {@link cr.ac.ucenfotec.test.domain.ExclusiveContent}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ExclusiveContentResource {

    private final Logger log = LoggerFactory.getLogger(ExclusiveContentResource.class);

    private static final String ENTITY_NAME = "exclusiveContent";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ExclusiveContentRepository exclusiveContentRepository;

    public ExclusiveContentResource(ExclusiveContentRepository exclusiveContentRepository) {
        this.exclusiveContentRepository = exclusiveContentRepository;
    }

    /**
     * {@code POST  /exclusive-contents} : Create a new exclusiveContent.
     *
     * @param exclusiveContent the exclusiveContent to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new exclusiveContent, or with status {@code 400 (Bad Request)} if the exclusiveContent has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/exclusive-contents")
    public ResponseEntity<ExclusiveContent> createExclusiveContent(@Valid @RequestBody ExclusiveContent exclusiveContent) throws URISyntaxException {
        log.debug("REST request to save ExclusiveContent : {}", exclusiveContent);
        if (exclusiveContent.getId() != null) {
            throw new BadRequestAlertException("A new exclusiveContent cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ExclusiveContent result = exclusiveContentRepository.save(exclusiveContent);
        return ResponseEntity.created(new URI("/api/exclusive-contents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /exclusive-contents} : Updates an existing exclusiveContent.
     *
     * @param exclusiveContent the exclusiveContent to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated exclusiveContent,
     * or with status {@code 400 (Bad Request)} if the exclusiveContent is not valid,
     * or with status {@code 500 (Internal Server Error)} if the exclusiveContent couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/exclusive-contents")
    public ResponseEntity<ExclusiveContent> updateExclusiveContent(@Valid @RequestBody ExclusiveContent exclusiveContent) throws URISyntaxException {
        log.debug("REST request to update ExclusiveContent : {}", exclusiveContent);
        if (exclusiveContent.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ExclusiveContent result = exclusiveContentRepository.save(exclusiveContent);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, exclusiveContent.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /exclusive-contents} : get all the exclusiveContents.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of exclusiveContents in body.
     */
    @GetMapping("/exclusive-contents")
    public List<ExclusiveContent> getAllExclusiveContents() {
        log.debug("REST request to get all ExclusiveContents");
        return exclusiveContentRepository.findAll();
    }

    /**
     * {@code GET  /exclusive-contents/:id} : get the "id" exclusiveContent.
     *
     * @param id the id of the exclusiveContent to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the exclusiveContent, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/exclusive-contents/{id}")
    public ResponseEntity<ExclusiveContent> getExclusiveContent(@PathVariable Long id) {
        log.debug("REST request to get ExclusiveContent : {}", id);
        Optional<ExclusiveContent> exclusiveContent = exclusiveContentRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(exclusiveContent);
    }

    /**
     * {@code DELETE  /exclusive-contents/:id} : delete the "id" exclusiveContent.
     *
     * @param id the id of the exclusiveContent to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/exclusive-contents/{id}")
    public ResponseEntity<Void> deleteExclusiveContent(@PathVariable Long id) {
        log.debug("REST request to delete ExclusiveContent : {}", id);
        exclusiveContentRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
