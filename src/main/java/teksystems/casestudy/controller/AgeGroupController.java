package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.AgeGroupFormBean;
import teksystems.casestudy.services.SecurityServices;

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

        User user = securityServices.getSecureUser();

        List<AgeGroup> ageGroup = ageGroupDao.findByUserId(user.getId());

        response.addObject("ageGroup", ageGroup);

        return response;
    }

    @PostMapping("user/addAgeGroup")
    public ModelAndView addAgeGroup(AgeGroupFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        AgeGroup agegroup = ageGroupDao.findById(form.getId());

        if(agegroup == null) {
            agegroup = new AgeGroup();
        }

        User user = securityServices.getSecureUser();

        log.info(form.toString());

        agegroup.setAgeGroup(form.getAgeGroup());

        Integer age = form.getAge();
        log.info(form.getPeriod());
        if (form.getPeriod().equals("Years")) {
            age = age*12;
            agegroup.setAge(age);
        } else { agegroup.setAge(age);}

        agegroup.setCost(form.getCost());

        agegroup.setUser(user);

        ageGroupDao.save(agegroup);

        response.setViewName("redirect:/user/agegroup/");
        return response;
    }
}
