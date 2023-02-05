package pl.gruchotki.invoicesIntegrator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;
import pl.gruchotki.invoicesIntegrator.repository.InvoiceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDtoResponse get(Long id) {
        return null;
    }

    @Override
    public List<InvoiceDtoResponse> getAll() {
        return null;
    }
}
