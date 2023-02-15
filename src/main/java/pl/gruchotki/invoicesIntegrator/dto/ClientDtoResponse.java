package pl.gruchotki.invoicesIntegrator.dto;

import pl.gruchotki.invoicesIntegrator.entity.ClientEntity;

public class ClientDtoResponse {
    private String buyerNip;
    private String name;
    private String nip;
    private String street;
    private String postalCode;
    private String city;

    public ClientDtoResponse(ClientEntity client) {
        this.buyerNip = client.getBuyerNip();
        this.name = client.getName();
        this.nip = client.getNip();
        this.street = client.getStreet();
        this.postalCode = client.getPostalCode();
        this.city = client.getCity();
    }
}
