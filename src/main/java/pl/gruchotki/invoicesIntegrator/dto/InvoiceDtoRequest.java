package pl.gruchotki.invoicesIntegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDtoRequest {
    private String number;
    private Double payment;
    private Double paymentOnDocument;
    private LocalDate issueDate;
    private LocalDate paymentDate;
    private LocalDate saleDate;
    private String paymentType;
    private String numberingSeriesName;
    private String templateName;
    private String comments;
    private String buyerNip;
    private String name;
    private String nip;
    private String street;
    private String postalCode;
    private String city;
}