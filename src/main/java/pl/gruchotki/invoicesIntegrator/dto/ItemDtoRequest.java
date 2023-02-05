package pl.gruchotki.invoicesIntegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDtoRequest {
    private String number;
    private Double vatRate;
    private Integer quantity;
    private Double unitPrice;
    private String fullName;
}
