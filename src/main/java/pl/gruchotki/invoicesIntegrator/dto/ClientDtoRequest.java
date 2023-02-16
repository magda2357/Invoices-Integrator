package pl.gruchotki.invoicesIntegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {
    private String number;
    private String buyerNip;
    private String name;
    private String nip;
    private String street;
    private String postalCode;
    private String city;
}
