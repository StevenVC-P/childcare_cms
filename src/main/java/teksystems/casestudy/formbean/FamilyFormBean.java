package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class FamilyFormBean {

    private Integer id;

    @NotBlank(message = "Primary Contact cannot be blank")
    private String primaryContact;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "City cannot be blank")
    private String city;

    private String state;

    @NotBlank(message = "Zip cannot be blank")
    private String zip;
}
