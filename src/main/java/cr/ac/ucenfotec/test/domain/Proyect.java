package cr.ac.ucenfotec.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import cr.ac.ucenfotec.test.domain.enumeration.ProyectType;

/**
 * A Proyect.
 */
@Entity
@Table(name = "proyect")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Proyect implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @NotNull
    @Size(max = 300)
    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "id_type", nullable = false)
    private ProyectType idType;

    @NotNull
    @DecimalMin(value = "1")
    @Column(name = "goal_amount", nullable = false)
    private Double goalAmount;

    @DecimalMin(value = "0")
    @Column(name = "collected")
    private Double collected;

    @Column(name = "rating")
    private Double rating;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private ZonedDateTime creationDate;

    @Column(name = "last_updated")
    private ZonedDateTime lastUpdated;

    @NotNull
    @Column(name = "coord_x", nullable = false)
    private Long coordX;

    @NotNull
    @Column(name = "coord_y", nullable = false)
    private Long coordY;

    @NotNull
    @Column(name = "fee", nullable = false)
    private Double fee;

    @OneToOne
    @JoinColumn(unique = true)
    private ProyectAccount account;

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<DonationHistory> donations = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Checkpoint> checkpoints = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<PartnerRequest> partners = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Raffle> raffles = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Auction> auctions = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<ExclusiveContent> exclusiveContents = new HashSet<>();

    @OneToMany(mappedBy = "proyect")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Payment> payments = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "proyects", allowSetters = true)
    private ApplicationUser owner;

    @ManyToOne
    @JsonIgnoreProperties(value = "favorites", allowSetters = true)
    private ApplicationUser applicationUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "proyects", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Proyect name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Proyect description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProyectType getIdType() {
        return idType;
    }

    public Proyect idType(ProyectType idType) {
        this.idType = idType;
        return this;
    }

    public void setIdType(ProyectType idType) {
        this.idType = idType;
    }

    public Double getGoalAmount() {
        return goalAmount;
    }

    public Proyect goalAmount(Double goalAmount) {
        this.goalAmount = goalAmount;
        return this;
    }

    public void setGoalAmount(Double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Double getCollected() {
        return collected;
    }

    public Proyect collected(Double collected) {
        this.collected = collected;
        return this;
    }

    public void setCollected(Double collected) {
        this.collected = collected;
    }

    public Double getRating() {
        return rating;
    }

    public Proyect rating(Double rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Proyect creationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    public Proyect lastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public void setLastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getCoordX() {
        return coordX;
    }

    public Proyect coordX(Long coordX) {
        this.coordX = coordX;
        return this;
    }

    public void setCoordX(Long coordX) {
        this.coordX = coordX;
    }

    public Long getCoordY() {
        return coordY;
    }

    public Proyect coordY(Long coordY) {
        this.coordY = coordY;
        return this;
    }

    public void setCoordY(Long coordY) {
        this.coordY = coordY;
    }

    public Double getFee() {
        return fee;
    }

    public Proyect fee(Double fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public ProyectAccount getAccount() {
        return account;
    }

    public Proyect account(ProyectAccount proyectAccount) {
        this.account = proyectAccount;
        return this;
    }

    public void setAccount(ProyectAccount proyectAccount) {
        this.account = proyectAccount;
    }

    public Set<Image> getImages() {
        return images;
    }

    public Proyect images(Set<Image> images) {
        this.images = images;
        return this;
    }

    public Proyect addImage(Image image) {
        this.images.add(image);
        image.setProyect(this);
        return this;
    }

    public Proyect removeImage(Image image) {
        this.images.remove(image);
        image.setProyect(null);
        return this;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<DonationHistory> getDonations() {
        return donations;
    }

    public Proyect donations(Set<DonationHistory> donationHistories) {
        this.donations = donationHistories;
        return this;
    }

    public Proyect addDonation(DonationHistory donationHistory) {
        this.donations.add(donationHistory);
        donationHistory.setProyect(this);
        return this;
    }

    public Proyect removeDonation(DonationHistory donationHistory) {
        this.donations.remove(donationHistory);
        donationHistory.setProyect(null);
        return this;
    }

    public void setDonations(Set<DonationHistory> donationHistories) {
        this.donations = donationHistories;
    }

    public Set<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public Proyect checkpoints(Set<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
        return this;
    }

    public Proyect addCheckpoint(Checkpoint checkpoint) {
        this.checkpoints.add(checkpoint);
        checkpoint.setProyect(this);
        return this;
    }

    public Proyect removeCheckpoint(Checkpoint checkpoint) {
        this.checkpoints.remove(checkpoint);
        checkpoint.setProyect(null);
        return this;
    }

    public void setCheckpoints(Set<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Proyect reviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Proyect addReview(Review review) {
        this.reviews.add(review);
        review.setProyect(this);
        return this;
    }

    public Proyect removeReview(Review review) {
        this.reviews.remove(review);
        review.setProyect(null);
        return this;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<PartnerRequest> getPartners() {
        return partners;
    }

    public Proyect partners(Set<PartnerRequest> partnerRequests) {
        this.partners = partnerRequests;
        return this;
    }

    public Proyect addPartner(PartnerRequest partnerRequest) {
        this.partners.add(partnerRequest);
        partnerRequest.setProyect(this);
        return this;
    }

    public Proyect removePartner(PartnerRequest partnerRequest) {
        this.partners.remove(partnerRequest);
        partnerRequest.setProyect(null);
        return this;
    }

    public void setPartners(Set<PartnerRequest> partnerRequests) {
        this.partners = partnerRequests;
    }

    public Set<Raffle> getRaffles() {
        return raffles;
    }

    public Proyect raffles(Set<Raffle> raffles) {
        this.raffles = raffles;
        return this;
    }

    public Proyect addRaffle(Raffle raffle) {
        this.raffles.add(raffle);
        raffle.setProyect(this);
        return this;
    }

    public Proyect removeRaffle(Raffle raffle) {
        this.raffles.remove(raffle);
        raffle.setProyect(null);
        return this;
    }

    public void setRaffles(Set<Raffle> raffles) {
        this.raffles = raffles;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public Proyect auctions(Set<Auction> auctions) {
        this.auctions = auctions;
        return this;
    }

    public Proyect addAuction(Auction auction) {
        this.auctions.add(auction);
        auction.setProyect(this);
        return this;
    }

    public Proyect removeAuction(Auction auction) {
        this.auctions.remove(auction);
        auction.setProyect(null);
        return this;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Set<ExclusiveContent> getExclusiveContents() {
        return exclusiveContents;
    }

    public Proyect exclusiveContents(Set<ExclusiveContent> exclusiveContents) {
        this.exclusiveContents = exclusiveContents;
        return this;
    }

    public Proyect addExclusiveContent(ExclusiveContent exclusiveContent) {
        this.exclusiveContents.add(exclusiveContent);
        exclusiveContent.setProyect(this);
        return this;
    }

    public Proyect removeExclusiveContent(ExclusiveContent exclusiveContent) {
        this.exclusiveContents.remove(exclusiveContent);
        exclusiveContent.setProyect(null);
        return this;
    }

    public void setExclusiveContents(Set<ExclusiveContent> exclusiveContents) {
        this.exclusiveContents = exclusiveContents;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public Proyect payments(Set<Payment> payments) {
        this.payments = payments;
        return this;
    }

    public Proyect addPayment(Payment payment) {
        this.payments.add(payment);
        payment.setProyect(this);
        return this;
    }

    public Proyect removePayment(Payment payment) {
        this.payments.remove(payment);
        payment.setProyect(null);
        return this;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public Proyect owner(ApplicationUser applicationUser) {
        this.owner = applicationUser;
        return this;
    }

    public void setOwner(ApplicationUser applicationUser) {
        this.owner = applicationUser;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public Proyect applicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
        return this;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Category getCategory() {
        return category;
    }

    public Proyect category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proyect)) {
            return false;
        }
        return id != null && id.equals(((Proyect) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Proyect{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", idType='" + getIdType() + "'" +
            ", goalAmount=" + getGoalAmount() +
            ", collected=" + getCollected() +
            ", rating=" + getRating() +
            ", creationDate='" + getCreationDate() + "'" +
            ", lastUpdated='" + getLastUpdated() + "'" +
            ", coordX=" + getCoordX() +
            ", coordY=" + getCoordY() +
            ", fee=" + getFee() +
            "}";
    }
}
