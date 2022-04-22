package teksystems.casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ChildDAO;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.FamilyFormBean;
import teksystems.casestudy.services.SecurityServices;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

    @Slf4j
@Controller
public class ParentController {

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    private ChildDAO childDao;

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
    public ModelAndView addFamily(@Valid FamilyFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("registered");
        Parent parent = parentDao.findById(form.getId());

        if (bindingResult.hasErrors()) {
            log.info("Errors!");
            List<String> errorMessages = new ArrayList<>();

            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                errorMessages.add(error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);
            log.info(String.valueOf(bindingResult.getAllErrors()));

            response.setViewName("user/addFamily");
            return response;
        }

        if(parent == null) {
            parent = new Parent();
        }

        User user = securityServices.getSecureUser();

        log.info("parent");

        log.info(String.valueOf(user));

        log.info(form.getPrimaryContact());
        parent.setPrimaryContact(form.getPrimaryContact());
        parent.setEmail(form.getEmail());
        parent.setPrimaryPhoneNumber(form.getPhone());
        parent.setAddress(form.getAddress());
        parent.setCity(form.getCity());
        parent.setState(form.getState());
        parent.setZip(form.getZip());

        parent.setUser(user);

        log.info(form.toString());

        parentDao.save(parent);

        response.setViewName("redirect:/user/families/");

        return response;
    }


    @GetMapping("/user/families/{parent.id}/delete")
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

    @GetMapping("/user/editFamily/{parent.id}")
    public ModelAndView editFamily(@PathVariable("parent.id") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        Parent parent = parentDao.findById(id);
        log.info(String.valueOf(parent));

        FamilyFormBean form = new FamilyFormBean();
        form.setId(parent.getId());
        form.setPrimaryContact(parent.getPrimaryContact());
        form.setEmail(parent.getEmail());
        form.setPhone(parent.getPrimaryPhoneNumber());
        form.setAddress(parent.getAddress());
        form.setCity(parent.getCity());
        form.setState(parent.getState());
        form.setZip(parent.getZip());

        log.info(String.valueOf(form));
        response.addObject("form", form);
        response.setViewName("user/editFamily");
        return response;
    }

}
