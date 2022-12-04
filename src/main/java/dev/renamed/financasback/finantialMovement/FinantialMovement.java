package dev.renamed.financasback.finantialMovement;

import dev.renamed.financasback.category.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "finantial_movements",
        indexes = {
            @Index(name = "idx_mov_date_order", columnList = "invoiceDate asc, expectedDate asc")
        })
public class FinantialMovement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    private LocalDate expectedDate;

    private LocalDate invoiceDate;

    @Column(nullable = false)
    private String description;

    private long expectedValue;

    private long availableValue;

    private long invoiceValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinTable(name = "movement_category",
                joinColumns = {@JoinColumn(name="movements_id", referencedColumnName="id")},
                inverseJoinColumns = {@JoinColumn(name="catogories_id", referencedColumnName = "id")})
    private Category category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(long expectedValue) {
        this.expectedValue = expectedValue;
    }

    public long getAvailableValue() {
        return availableValue;
    }

    public void setAvailableValue(long availableValue) {
        this.availableValue = availableValue;
    }

    public long getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(long invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
