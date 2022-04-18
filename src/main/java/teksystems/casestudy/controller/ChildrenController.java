package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.dao.ChildDao;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.ChildFormBean;
import teksystems.casestudy.services.AgeGroupServices;
import teksystems.casestudy.services.ChildServices;
import teksystems.casestudy.services.SecurityServices;

import java.time.LocalDate;
import java.time.Period;
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
        response.setViewName("/user/children");

        List<Child> children = childDao.findByParentId(familyId);

        response.addObject("children", children);

        return response;
    }

//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @PostMapping("/user/{family_id}/addChildren/")
    public ModelAndView addChild(ChildFormBean form, @RequestParam("birthDay") String birthDay,
                                 @PathVariable("family_id") Integer familyId,
                                 @RequestParam(value ="id", required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        Child child = childDao.findById(id);

        if(child == null) {
            child = new Child();
        }

        Parent parent = parentDao.findById(familyId);

        if (form.getFirstName().isEmpty()) {
            child.setFirstName(child.getFirstName());
        } else {
            child.setFirstName(form.getFirstName());
        }

        if (form.getLastName().isEmpty()) {
            child.setLastName(child.getLastName());
        } else {
            child.setLastName(form.getLastName());
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
