package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.AgeGroupFormBean;
import teksystems.casestudy.services.AgeGroupServices;
import teksystems.casestudy.services.SecurityServices;

import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class AgeGroupController {

    @Autowired
    private AgeGroupDAO ageGroupDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @GetMapping("/user/agegroup")
    public ModelAndView agegroup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/agegroup");

        List<AgeGroup> listAgeGroup = orderAgeGroup();
        response.addObject("ageGroup", listAgeGroup);

        return response;
    }

    @PostMapping("user/addAgeGroup")
    public ModelAndView addAgeGroup(AgeGroupFormBean form, @RequestParam(value ="id", required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        AgeGroup agegroup = ageGroupDao.findById(id);

        if (agegroup == null) {
            agegroup = new AgeGroup();
        }

        User user = securityServices.getSecureUser();

        if (form.getAgeGroup().isEmpty()) {
            agegroup.setAgeGroup(agegroup.getAgeGroup());
        } else {
            agegroup.setAgeGroup(form.getAgeGroup());
        }

        if (form.getAge() == null) {
            agegroup.setAge(agegroup.getAge());
        } else {
            Integer age = form.getAge();
            if (form.getPeriod().equals("Years")) {
                age = age * 12;
                agegroup.setAge(age);
            } else {
                agegroup.setAge(age);
            }
        }

        if (form.getCost() == null) {
            agegroup.setCost(agegroup.getCost());
        } else {
            agegroup.setCost(form.getCost());
        }

        agegroup.setUser(user);

        ageGroupDao.save(agegroup);

        response.setViewName("redirect:/user/agegroup/");
        return response;
    }

    @GetMapping("user/agegroup/{agegroup_id}")
    public ModelAndView deleteAgeGroup(@PathVariable("agegroup_id") Integer ageGroupId) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(String.valueOf(ageGroupId));

        AgeGroup ageGroup = ageGroupDao.findById(ageGroupId);

        ageGroupDao.delete(ageGroup);

        response.setViewName("redirect:/user/agegroup/");
        return response;
    }

    public List<AgeGroup> orderAgeGroup (){
        User user = securityServices.getSecureUser();
        List<AgeGroup> listAgeGroup = ageGroupDao.findByUserId(user.getId());
        Collections.sort(listAgeGroup);

        return listAgeGroup;
    }
}
