package pl.gruchotki.invoicesIntegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDtoRequest {
    private String number;
    private BigDecimal payment;
    private BigDecimal paymentOnDocument;
    private LocalDate issueDate;
    private LocalDate paymentDate;
    private LocalDate saleDate;
    private String comments;
}
