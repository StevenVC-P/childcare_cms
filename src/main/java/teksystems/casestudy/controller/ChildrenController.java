package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ChildDao;
import teksystems.casestudy.database.entitymodels.Child;

import java.util.List;

@Slf4j
@Controller
public class ChildrenController {

    @Autowired
    private ChildDao childDao;

    @GetMapping("/user/children")
    public ModelAndView children() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/user/children");

        List<Child> children = childDao.findByParentId(1);

        response.addObject("children", children);

        return response;
    }
}
