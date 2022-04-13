package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.dao.UserRolesDAO;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.database.entitymodels.UserRoles;
import teksystems.casestudy.formbean.RegisterFormBean;

import java.util.Date;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRolesDAO userRolesDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login/registerSubmit")
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception{
        ModelAndView response = new ModelAndView();

        User user = userDao.findById(form.getId());
        UserRoles userRoles = new UserRoles();

        if(user == null) {
            user = new User();
        }

        user.setUserName(form.getUserName());
        user.setEmail(form.getEmail());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        log.info(form.toString());

        userRoles.setUserId(user.getId());
        userRoles.setUserRole("User");
        userRolesDao.save(userRoles);

        response.setViewName("redirect:/user/families/");

        return response;
    }


}
