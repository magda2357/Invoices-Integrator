package pl.gruchotki.invoicesIntegrator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchotki.invoicesIntegrator.dto.ItemDtoResponse;
import pl.gruchotki.invoicesIntegrator.dto.ItemsDtoResponse;
import pl.gruchotki.invoicesIntegrator.service.ItemService;

@RestController
@RequestMapping("/invoice/{invoiceId}/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("{itemId}")
    public ItemDtoResponse get(@PathVariable Long invoiceId, @PathVariable Long itemId) {
        return itemService.get(invoiceId, itemId);
    }

    @GetMapping
    public ItemsDtoResponse getInvoiceItems(@PathVariable Long invoiceId) {
        return itemService.getInvoiceItems(invoiceId);
    }
}
