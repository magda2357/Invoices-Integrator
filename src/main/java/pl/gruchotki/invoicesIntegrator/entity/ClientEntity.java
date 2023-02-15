package pl.gruchotki.invoicesIntegrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String number;
    private String buyerNip;
    private String name;
    private String nip;
    private String street;
    private String postalCode;
    private String city;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    public ClientEntity(Long id,
                        String number,
                        String buyerNip,
                        String name,
                        String nip,
                        String street,
                        String postalCode,
                        String city,
                        InvoiceEntity invoice) {
        this.id = id;
        this.number = number;
        this.buyerNip = buyerNip;
        this.name = name;
        this.nip = nip;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.invoice = invoice;
    }
}
