package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    private String userName;

//    @EmailUnique(message = "Email already exists in the database")
    @NotBlank(message = "Email is required")
    @Email(message = "Email format invalid")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format is invalid")
    private String email;

    private String password;

    private String confirmPassword;
}
