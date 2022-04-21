package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CreateInvoicesFormBean {

    private String[] invoice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;
}
