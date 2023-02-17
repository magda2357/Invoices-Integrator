package pl.gruchotki.invoicesIntegrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
@Getter
@Setter
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal payment;
    private BigDecimal paymentOnDocument;

    @Enumerated(STRING)
    private TaxBase taxBase;

    @Max(28)
    private String bankingAccountNumber;
//    >= data sprzedaży;
//>= data wystawienia faktury wcześniejszej;
//<= 15 dzień miesiąca następnego względem daty sprzedaży

    private LocalDate issueDate;

    @Max(50)
    private String issuePlace;

    @Enumerated(STRING)
    private SaleDateFormat saleDateFormat;
    private LocalDate paymentDate;
    //    >= data sprzedaży
    private LocalDate saleDate;

    @Enumerated(STRING)
    private PaymentType paymentType;
    private String numberingSeriesName;
    private String templateName;

    @Enumerated(STRING)
    private ReceiverSignatureType receiverSignatureType;
    private String comments;
    private String visibleGiosNumberBdoNumber;
    private String number;

    @OneToMany(
            mappedBy = "invoice",
            cascade = ALL
    )
    private List<ItemEntity> items = new ArrayList<>();

    @OneToOne(
            mappedBy = "invoice",
            cascade = ALL
    )
    private ClientEntity client = new ClientEntity();

    public InvoiceEntity(
            BigDecimal payment,
            BigDecimal paymentOnDocument,
            TaxBase taxBase,
            String bankingAccountNumber,
            LocalDate issueDate,
            String issuePlace,
            SaleDateFormat saleDateFormat,
            LocalDate paymentDate,
            LocalDate saleDate,
            PaymentType paymentType,
            String numberingSeriesName,
            String templateName,
            ReceiverSignatureType receiverSignatureType,
            String comments,
            String visibleGiosNumberBdoNumber,
            String number) {
        this.payment = payment;
        this.paymentOnDocument = paymentOnDocument;
        this.taxBase = taxBase;
        this.bankingAccountNumber = bankingAccountNumber;
        this.issueDate = issueDate;
        this.issuePlace = issuePlace;
        this.saleDateFormat = saleDateFormat;
        this.paymentDate = paymentDate;
        this.saleDate = saleDate;
        this.paymentType = paymentType;
        this.numberingSeriesName = numberingSeriesName;
        this.templateName = templateName;
        this.receiverSignatureType = receiverSignatureType;
        this.comments = comments;
        this.visibleGiosNumberBdoNumber = visibleGiosNumberBdoNumber;
        this.number = number;
    }
}
