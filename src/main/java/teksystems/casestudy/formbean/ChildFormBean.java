package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ChildFormBean {

    private Integer id;

    @NotBlank(message = "Why would you not name your child!")
    private String childName;

    @NotNull(message = "Dumb-dumb, when were they born?")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
}
