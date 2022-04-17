package teksystems.casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ChildDao;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.FamilyFormBean;
import teksystems.casestudy.services.SecurityServices;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ParentController {

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    private ChildDao childDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @GetMapping("/user/families")
    public ModelAndView families() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/families");

        User user = securityServices.getSecureUser();

        List<Parent> parents = parentDao.findByUserId(user.getId());

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

        User user = securityServices.getSecureUser();

        log.info("parent");

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


    @GetMapping("/user/families/{parent.id}")
    public ModelAndView deleteParent(@PathVariable("parent.id") Integer parentId) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("hit path");
        Parent parent = parentDao.findById(parentId);

        List<Child> children = childDao.findByParentId(parentId);

        for (int i = 0; i < children.size(); i++) {
            Child child = children.get(i);
            childDao.delete(child);
        }

        parentDao.delete(parent);
        log.info("parent removed");
        response.setViewName("redirect:/user/families");
        return response;
    }
}
