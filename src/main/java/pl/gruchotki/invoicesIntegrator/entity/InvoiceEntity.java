package pl.gruchotki.invoicesIntegrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
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
    private Double zaplacono;
    private Double zaplaconoNaDokumencie;

    @Enumerated
    private TaxBase liczOd;

    @Max(28)
    private String numerKontaBankowego;
//    >= data sprzedaży;
//>= data wystawienia faktury wcześniejszej;
//<= 15 dzień miesiąca następnego względem daty sprzedaży

    private LocalDate dataWystawienia;

    @Max(50)
    private final String miejsceWystawienia = "Budy Michałowskie";

    @Enumerated
    private SaleDateFormat formatDatySprzedazy;
    private LocalDate terminPlatnosci;
    //    >= data sprzedaży
    private LocalDate dataSprzedazy;

    @Enumerated(STRING)
    private PaymentType sposobZaplaty;
    private String nazwaSeriiNumeracji;
    private String nazwaSzablonu;

    @Enumerated
    private ReceiverSignatureType rodzajPodpisuOdbiorcy;
    private String uwagi;
    private Integer widocznyNumerGiosWidocznyNumerBdo;
    private String numer;
    private Integer NIPKontrahenta;
    private String nazwa;
    private String NIP;
    private String ulica;
    private String kodPocztowy;
    private String miejscowosc;

    @OneToMany(
            mappedBy = "invoice",
            cascade = ALL
    )
    private List<ItemEntity> items = new ArrayList<>();

    public InvoiceEntity(Double zaplacono,
                         Double zaplaconoNaDokumencie,
                         TaxBase liczOd,
                         String numerKontaBankowego,
                         LocalDate dataWystawienia,
                         SaleDateFormat formatDatySprzedazy,
                         LocalDate terminPlatnosci,
                         LocalDate dataSprzedazy,
                         PaymentType sposobZaplaty,
                         String nazwaSeriiNumeracji,
                         String nazwaSzablonu,
                         ReceiverSignatureType rodzajPodpisuOdbiorcy,
                         String uwagi,
                         Integer widocznyNumerGiosWidocznyNumerBdo,
                         String numer,
                         Integer NIPKontrahenta,
                         String nazwa,
                         String NIP,
                         String ulica,
                         String kodPocztowy,
                         String miejscowosc) {
        this.zaplacono = zaplacono;
        this.zaplaconoNaDokumencie = zaplaconoNaDokumencie;
        this.liczOd = liczOd;
        this.numerKontaBankowego = numerKontaBankowego;
        this.dataWystawienia = dataWystawienia;
        this.formatDatySprzedazy = formatDatySprzedazy;
        this.terminPlatnosci = terminPlatnosci;
        this.dataSprzedazy = dataSprzedazy;
        this.sposobZaplaty = sposobZaplaty;
        this.nazwaSeriiNumeracji = nazwaSeriiNumeracji;
        this.nazwaSzablonu = nazwaSzablonu;
        this.rodzajPodpisuOdbiorcy = rodzajPodpisuOdbiorcy;
        this.uwagi = uwagi;
        this.widocznyNumerGiosWidocznyNumerBdo = widocznyNumerGiosWidocznyNumerBdo;
        this.numer = numer;
        this.NIPKontrahenta = NIPKontrahenta;
        this.nazwa = nazwa;
        this.NIP = NIP;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
    }
}
