package pl.gruchotki.invoicesIntegrator.dto;

import pl.gruchotki.invoicesIntegrator.entity.ItemEntity;
import pl.gruchotki.invoicesIntegrator.entity.VatRateType;

import java.math.BigDecimal;

public class ItemDtoResponse {
    private Double vatRate;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String fullName;
    private String unit;
    private VatRateType vatRateType;

    public ItemDtoResponse(ItemEntity item) {
        this.vatRate = item.getVatRate();
        this.quantity = item.getQuantity();
        this.unitPrice = item.getUnitPrice();
        this.fullName = item.getFullName();
        this.unit = item.getUnit();
        this.vatRateType = item.getVatRateType();
    }
}
