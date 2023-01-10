package pl.gruchotki.invoicesIntegrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    private Double stawkaVat;
    private Integer ilosc;
    private Double cenaJednostkowa;

    @Min(1)
    @Max(300)
    private String nazwaPelna;
    private String jednostka = "sztuk";

    @Enumerated
    private VatRateType typStawkiVat;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    public ItemEntity(Double stawkaVat,
                      Integer ilosc,
                      Double cenaJednostkowa,
                      String nazwaPelna,
                      String jednostka,
                      VatRateType typStawkiVat) {
        this.stawkaVat = stawkaVat;
        this.ilosc = ilosc;
        this.cenaJednostkowa = cenaJednostkowa;
        this.nazwaPelna = nazwaPelna;
        this.jednostka = jednostka;
        this.typStawkiVat = typStawkiVat;
    }
}
