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

@Slf4j
@Controller
public class ParentController {

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    private UserDAO userDao;

//    @GetMapping("/user/families")
//    public ModelAndView families(@RequestParam("id") Integer id) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("user/families");
//
//        return response;
//    }

    @PostMapping("/user/families/{id}")
    public ModelAndView addFamily(@PathVariable("id") Integer id, FamilyFormBean familyForm) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(String.valueOf(id));

        Parent parent = new Parent();
        User user = userDao.findById(id);
        log.info(String.valueOf(user));

        log.info(familyForm.getPrimaryContact());
        parent.setPriContact(familyForm.getPrimaryContact());
        parent.setEMail(familyForm.getEmail());
        parent.setPriPhoneNumber(familyForm.getPhone());
        parent.setStreetAddress(familyForm.getAddress());
        parent.setCity(familyForm.getCity());
        parent.setState(familyForm.getState());
        parent.setZip(familyForm.getZip());
        parent.setUser(user);

        log.info(familyForm.toString());

        parentDao.save(parent);

        response.setViewName("/user/families");

        return response;
    }
}
