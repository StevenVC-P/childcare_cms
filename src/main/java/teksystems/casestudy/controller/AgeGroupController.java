package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;

@Slf4j
@Controller
public class AgeGroupController {

    @Autowired
    private AgeGroupDAO ageGroupDao;

    @GetMapping("/user/agegroup")
    public ModelAndView agegroup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/agegroup");
        return response;
    }

}
