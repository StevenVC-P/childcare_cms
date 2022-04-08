package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    private String userName;

    private String email;

    private String password;

    private String confirmPassword;
}
