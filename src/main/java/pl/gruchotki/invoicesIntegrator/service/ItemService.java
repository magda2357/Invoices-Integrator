package pl.gruchotki.invoicesIntegrator.service;

import pl.gruchotki.invoicesIntegrator.dto.ItemDtoResponse;
import pl.gruchotki.invoicesIntegrator.dto.ItemsDtoResponse;

public interface ItemService {
    ItemsDtoResponse getInvoiceItems(Long invoiceId);
    ItemDtoResponse get(Long invoiceId, Long itemId);
}
