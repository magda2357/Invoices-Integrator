package pl.gruchotki.invoicesIntegrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Double vatRate;
    private Integer quantity;
    private BigDecimal unitPrice;

    //    @Min(1)
//    @Max(300)
    private String fullName;
    private String unit;

    @Enumerated(STRING)
    private VatRateType vatRateType;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    public ItemEntity(Long id, Double vatRate, Integer quantity, BigDecimal unitPrice, String fullName, String unit, VatRateType vatRateType, InvoiceEntity invoice) {
        this.id = id;
        this.vatRate = vatRate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.fullName = fullName;
        this.unit = unit;
        this.vatRateType = vatRateType;
        this.invoice = invoice;
    }
}
