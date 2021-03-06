package cr.ac.ucenfotec.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

import cr.ac.ucenfotec.test.domain.enumeration.ActivityStatus;

/**
 * A Raffle.
 */
@Entity
@Table(name = "raffle")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Raffle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @Min(value = 1)
    @Column(name = "total_ticket", nullable = false)
    private Integer totalTicket;

    @NotNull
    @Column(name = "expiration_date", nullable = false)
    private ZonedDateTime expirationDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ActivityStatus state;

    @OneToOne
    @JoinColumn(unique = true)
    private Prize prize;

    @ManyToOne
    @JsonIgnoreProperties(value = "raffles", allowSetters = true)
    private ApplicationUser buyer;

    @ManyToOne
    @JsonIgnoreProperties(value = "raffles", allowSetters = true)
    private Proyect proyect;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public Raffle price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalTicket() {
        return totalTicket;
    }

    public Raffle totalTicket(Integer totalTicket) {
        this.totalTicket = totalTicket;
        return this;
    }

    public void setTotalTicket(Integer totalTicket) {
        this.totalTicket = totalTicket;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public Raffle expirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ActivityStatus getState() {
        return state;
    }

    public Raffle state(ActivityStatus state) {
        this.state = state;
        return this;
    }

    public void setState(ActivityStatus state) {
        this.state = state;
    }

    public Prize getPrize() {
        return prize;
    }

    public Raffle prize(Prize prize) {
        this.prize = prize;
        return this;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public ApplicationUser getBuyer() {
        return buyer;
    }

    public Raffle buyer(ApplicationUser applicationUser) {
        this.buyer = applicationUser;
        return this;
    }

    public void setBuyer(ApplicationUser applicationUser) {
        this.buyer = applicationUser;
    }

    public Proyect getProyect() {
        return proyect;
    }

    public Raffle proyect(Proyect proyect) {
        this.proyect = proyect;
        return this;
    }

    public void setProyect(Proyect proyect) {
        this.proyect = proyect;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Raffle)) {
            return false;
        }
        return id != null && id.equals(((Raffle) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Raffle{" +
            "id=" + getId() +
            ", price=" + getPrice() +
            ", totalTicket=" + getTotalTicket() +
            ", expirationDate='" + getExpirationDate() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
}
