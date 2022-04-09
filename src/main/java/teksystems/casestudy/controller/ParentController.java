package teksystems.casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.FamilyFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ParentController {

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    private UserDAO userDao;

    @GetMapping("/user/families")
    public ModelAndView families() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/families");

        List<Parent> parents = parentDao.findByUserId(1);

        response.addObject("parents", parents);

        return response;
    }

    @GetMapping("/user/addFamily/")
    public ModelAndView addFamily() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/addFamily");

        return response;
    }

    @PostMapping("/user/registerFamily/")
    public ModelAndView addFamily(FamilyFormBean familyForm) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("registered");
        Parent parent = parentDao.findById(familyForm.getId());
        if(parent == null) {
            parent = new Parent();
        }

        log.info("parent");
        User user = userDao.findById(1);
        log.info(String.valueOf(user));

        log.info(familyForm.getPrimaryContact());
        parent.setPrimaryContact(familyForm.getPrimaryContact());
        parent.setEmail(familyForm.getEmail());
        parent.setPrimaryPhoneNumber(familyForm.getPhone());
        parent.setAddress(familyForm.getAddress());
        parent.setCity(familyForm.getCity());
        parent.setState(familyForm.getState());
        parent.setZip(familyForm.getZip());

        parent.setUser(user);

        log.info(familyForm.toString());

        parentDao.save(parent);

        response.setViewName("redirect:/user/families/");

        return response;
    }
}
