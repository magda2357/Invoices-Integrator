package pl.gruchotki.invoicesIntegrator.dto;

import lombok.AllArgsConstructor;
import pl.gruchotki.invoicesIntegrator.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class InvoiceDtoResponse {
    private BigDecimal payment;
    private BigDecimal paymentOnDocument;
    private TaxBase taxBase;
    private String bankingAccountNumber;
    private LocalDate issueDate;
    private String issuePlace;
    private SaleDateFormat saleDateFormat;
    private LocalDate paymentDate;
    private LocalDate saleDate;
    private PaymentType paymentType;
    private String numberingSeriesName;
    private String templateName;
    private ReceiverSignatureType receiverSignatureType;
    private String comments;
    private String visibleGiosNumberBdoNumber;
    private String number;
//    private List<ItemDtoResponse> items;
//    private List<ClientDtoResponse> clients;

    public InvoiceDtoResponse(InvoiceEntity invoice) {
        this.payment = payment;
        this.paymentOnDocument = paymentOnDocument;
        this.taxBase = taxBase;
        this.bankingAccountNumber = bankingAccountNumber;
        this.issueDate = issueDate;
        this.issuePlace = issuePlace;
        this.saleDateFormat = saleDateFormat;
        this.paymentDate = paymentDate;
        this.saleDate = saleDate;
        this.paymentType = paymentType;
        this.numberingSeriesName = numberingSeriesName;
        this.templateName = templateName;
        this.receiverSignatureType = receiverSignatureType;
        this.comments = comments;
        this.visibleGiosNumberBdoNumber = visibleGiosNumberBdoNumber;
        this.number = number;
//        this.items = items;
//        this.clients = clients;
    }
}
