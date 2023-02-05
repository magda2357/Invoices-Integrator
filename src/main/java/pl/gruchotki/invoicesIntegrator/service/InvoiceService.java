package pl.gruchotki.invoicesIntegrator.service;

import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;

import java.util.List;

public interface InvoiceService {
    InvoiceDtoResponse get(Long id);
    List<InvoiceDtoResponse> getAll();

}
