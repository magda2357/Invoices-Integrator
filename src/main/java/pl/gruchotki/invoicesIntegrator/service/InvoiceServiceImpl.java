package pl.gruchotki.invoicesIntegrator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoRequest;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;
import pl.gruchotki.invoicesIntegrator.entity.InvoiceEntity;
import pl.gruchotki.invoicesIntegrator.repository.InvoiceRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static pl.gruchotki.invoicesIntegrator.entity.PaymentType.ELE;
import static pl.gruchotki.invoicesIntegrator.entity.ReceiverSignatureType.UOP;
import static pl.gruchotki.invoicesIntegrator.entity.SaleDateFormat.MSC;
import static pl.gruchotki.invoicesIntegrator.entity.TaxBase.NET;

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

    @Override
    public InvoiceDtoResponse saveInvoice(InvoiceDtoRequest newInvoice) {
        InvoiceEntity patientEntity = mapToEntity(newInvoice);
        InvoiceEntity save = invoiceRepository.save(patientEntity);
        return new InvoiceDtoResponse(save);
    }

    @Override
    public String saveInvoices(List<InvoiceDtoRequest> newInvoices) {
        List<InvoiceEntity> patientEntities = convertDtoToEntity(newInvoices);
        List<InvoiceEntity> save = invoiceRepository.saveAll(patientEntities);
        return "Invoices uploaded";
    }

    private InvoiceEntity mapToEntity(InvoiceDtoRequest dto) {
        return new InvoiceEntity(
                dto.getPayment(),
                dto.getPaymentOnDocument(),
                NET,
                "123",
                dto.getIssueDate(),
                "WAR",
                MSC,
                dto.getPaymentDate(),
                dto.getSaleDate(),
                ELE,
                "1",
                "default",
                UOP,
                dto.getComments(),
                "1",
                dto.getNumber()
        );

    }

    private static List<InvoiceEntity> convertDtoToEntity(List<InvoiceDtoRequest> aDto) {
        return aDto.stream()
                .map(dto -> new InvoiceEntity(
                        dto.getPayment(),
                        dto.getPaymentOnDocument(),
                        NET,
                        "123",
                        dto.getIssueDate(),
                        "WAR",
                        MSC,
                        dto.getPaymentDate(),
                        dto.getSaleDate(),
                        ELE,
                        "1",
                        "default",
                        UOP,
                        dto.getComments(),
                        "1",
                        dto.getNumber()))
                .collect(Collectors.toList());
    }

}
