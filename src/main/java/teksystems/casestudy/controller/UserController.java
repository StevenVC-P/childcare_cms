package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.RegisterFormBean;

import java.util.Date;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        return response;
    }


    @PostMapping("/user/registerSubmit")
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception{
        ModelAndView response = new ModelAndView();

        User user = userDao.findById(form.getId());

        if(user == null) {
            user = new User();
        }

        user.setUserName(form.getUserName());

        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());

        userDao.save(user);

        log.info(form.toString());

        response.setViewName("redirect:/user/families/");

        return response;
    }


}
