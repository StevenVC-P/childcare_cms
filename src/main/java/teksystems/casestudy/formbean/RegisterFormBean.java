package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;
import teksystems.casestudy.validation.EmailUnique;
import teksystems.casestudy.validation.PasswordsEqual;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@PasswordsEqual(fieldOneName="password", fieldTwoName="confirmPassword", message = "Confirm password must match password")
@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    @NotBlank(message = "Username cannot be blank")
    @NotEmpty(message = "A username is required")
    private String userName;

    @EmailUnique(message = "Email already exists in the database")
    @NotBlank(message = "Email is cannot be blank")
    @Email(message = "Email format invalid")
//    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format is invalid")
    private String email;

    @NotBlank(message = "Daycare name cannot be blank")
    @NotEmpty(message = "A daycare name is required")
    private String dayCare;

    @Length(min = 6, max = 15, message="Password must be between 6 and 15 characters")
    @NotBlank(message = "Password cannot be blank")
    @NotEmpty(message = "A Password is required")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    @NotEmpty(message = "Confirm password required")
    private String confirmPassword;
}
