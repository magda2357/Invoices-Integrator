package pl.gruchotki.invoicesIntegrator.dto;

import pl.gruchotki.invoicesIntegrator.entity.ClientEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ClientsDtoResponse {
    private final List<ClientDtoResponse> clients;

    public ClientsDtoResponse(List<ClientEntity> clients) {
        this.clients = clients.stream()
                .map(ClientDtoResponse::new)
                .collect(toList());
    }
}
