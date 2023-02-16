package pl.gruchotki.invoicesIntegrator.dto;

import pl.gruchotki.invoicesIntegrator.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceDtoResponse {
    private BigDecimal payment;
    private TaxBase taxBase;
    private String bankingAccountNumber;
    private LocalDate issueDate;
    private String issuePlace;
    private LocalDate saleDate;
    private SaleDateFormat saleDateFormat;
    private LocalDate paymentDate;
    private PaymentType paymentType;
    private String numberingSeriesName;
    private String templateName;
    private ReceiverSignatureType receiverSignatureType;
    private String comments;
    private Integer visibleGiosNumberBdoNumber;
    private String number;
    private List<ItemDtoResponse> items;
    private List<ClientDtoResponse> clients;

    public InvoiceDtoResponse(InvoiceEntity invoice, List<ItemDtoResponse> items, List<ClientDtoResponse> clients) {
        this.taxBase=invoice.getTaxBase();
        this.bankingAccountNumber=invoice.getBankingAccountNumber();
        this.issueDate=invoice.getIssueDate();
        this.issuePlace=invoice.getIssuePlace();
        this.saleDate=invoice.getSaleDate();
        this.saleDateFormat=invoice.getSaleDateFormat();
        this.paymentDate=invoice.getPaymentDate();
        this.paymentType=invoice.getPaymentType();
        this.numberingSeriesName=invoice.getNumberingSeriesName();
        this.templateName=invoice.getTemplateName();
        this.receiverSignatureType=invoice.getReceiverSignatureType();
        this.comments=invoice.getComments();
        this.visibleGiosNumberBdoNumber=invoice.getVisibleGiosNumberBdoNumber();
        this.number=invoice.getNumber();
        this.items=items;
        this.clients = clients;
    }
}
