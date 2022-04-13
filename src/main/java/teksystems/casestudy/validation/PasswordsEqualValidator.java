package teksystems.casestudy.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.formbean.RegisterFormBean;
import teksystems.casestudy.security.UserDetailsServiceImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordsEqualValidator implements ConstraintValidator<PasswordsEqual, RegisterFormBean>{

    public static final Logger Log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDAO userDao;

    @Override
    public void initialize(PasswordsEqual constraintAnnotation) {

    }

    public boolean isValid(RegisterFormBean form, ConstraintValidatorContext context) {
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();

        if(password == null || !password.equals(confirmPassword)) {
            return false;
        }

        return true;
    }
}
