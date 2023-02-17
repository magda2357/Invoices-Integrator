package pl.gruchotki.invoicesIntegrator.service;

import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoRequest;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;

import java.util.List;

public interface InvoiceService {
    InvoiceDtoResponse get(Long id);
    List<InvoiceDtoResponse> getAll();
    InvoiceDtoResponse saveInvoice(InvoiceDtoRequest newInvoice);
    String saveInvoices(List<InvoiceDtoRequest> newInvoice);
}
