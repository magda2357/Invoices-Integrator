package pl.gruchotki.invoicesIntegrator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;
import pl.gruchotki.invoicesIntegrator.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public InvoiceDtoResponse get(@PathVariable Long id) {
        return invoiceService.get(id);
    }

    @GetMapping
    public List<InvoiceDtoResponse> getAll() {
        return invoiceService.getAll();
    }

}
