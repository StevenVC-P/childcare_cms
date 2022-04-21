package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import teksystems.casestudy.database.dao.ChildDao;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.formbean.ChildFormBean;
import teksystems.casestudy.services.SecurityServices;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Controller
public class ChildrenController {

    @Autowired
    private ChildDao childDao;

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @GetMapping("/user/{family_id}/children")
    public ModelAndView children(@PathVariable("family_id") Integer familyId) throws Exception {
        log.info(String.valueOf(familyId));
        ModelAndView response = new ModelAndView();
        response.setViewName("user/children");

        List<Child> children = childDao.findByParentId(familyId);

        response.addObject("children", children);

        return response;
    }

//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @PostMapping("/user/{family_id}/addChildren/")
    public ModelAndView addChild(@Valid ChildFormBean form,
                                 BindingResult bindingResult,
                                 @PathVariable("family_id") Integer familyId,
                                 @RequestParam("birthDay") String birthDay,
                                 @RequestParam(value ="id", required = false) Integer id
                                 ) throws Exception {

        log.info("before response");
        ModelAndView response = new ModelAndView();

        Child child = childDao.findById(id);
        log.info("before if");
        if ( bindingResult.hasErrors()) {
            log.info("Errors!");
            List<String> errorMessages = new ArrayList<>();

            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                errorMessages.add(error.getDefaultMessage());
            }

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);
            log.info(String.valueOf(bindingResult.getAllErrors()));

            List<Child> children = childDao.findByParentId(familyId);
            response.addObject("children", children);

            response.setViewName("user/children");

            return response;
        }

        if(child == null) {
            child = new Child();
        }

        Parent parent = parentDao.findById(familyId);

        if (form.getChildName().isEmpty()) {
            child.setName(child.getName());
        } else {
            child.setName(form.getChildName());
        }

        if (birthDay.isEmpty()) {
            child.setBirthDate(child.getBirthDate());
        } else { child.setBirthDate(LocalDate.parse(birthDay));}

        child.setParent(parent);

        childDao.save(child);

        response.setViewName("redirect:/user/"+familyId+"/children/");

        return response;
    }

    @GetMapping("/user/children/{children.id}")
    public ModelAndView deleteChild(@PathVariable("children.id") Integer childId) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(String.valueOf(childId));

        Child child = childDao.findById(childId);

        Parent parent = child.getParent();
        Integer familyId = parent.getId();

        childDao.delete(child);

        response.setViewName("redirect:/user/"+familyId+"/children");
        return response;
    }

}
