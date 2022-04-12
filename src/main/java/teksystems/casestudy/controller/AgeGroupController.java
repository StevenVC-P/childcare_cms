package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.formbean.AgeGroupFormBean;

import java.util.List;

@Slf4j
@Controller
public class AgeGroupController {

    @Autowired
    private AgeGroupDAO ageGroupDao;

    @Autowired
    private UserDAO userDao;

    @GetMapping("/user/agegroup")
    public ModelAndView agegroup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/agegroup");

        List<AgeGroup> ageGroup = ageGroupDao.findByUserId(1);

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

        User user = userDao.findById(1);

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
