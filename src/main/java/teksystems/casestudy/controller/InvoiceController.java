package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.dao.ChildDao;
import teksystems.casestudy.database.dao.InvoiceDAO;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.entitymodels.*;
import teksystems.casestudy.formbean.CreateInvoicesFormBean;
import teksystems.casestudy.services.InvoiceWriter;
import teksystems.casestudy.services.SecurityServices;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class InvoiceController {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private AgeGroupDAO ageGroupDao;

    @Autowired
    private ParentDAO parentDao;

    @Autowired
    private ChildDao childDao;

    private final InvoiceWriter invoiceWriter = new InvoiceWriter();

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @GetMapping("/user/invoice")
    public ModelAndView invoice() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/invoice");

        User user = securityServices.getSecureUser();
        List<Invoice> listInvoices = invoiceDAO.findByUserId(user.getId());
        response.addObject("invoices", listInvoices);

        return response;
    }

    @GetMapping("/user/createInvoice")
    public ModelAndView createInvoiceView() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/createInvoice");

        User user = securityServices.getSecureUser();
        List<Parent> families = parentDao.findByUserId(user.getId());
        response.addObject("families", families);

        return response;
    }

    @PostMapping("/user/createInvoices/")
    public ModelAndView createInvoices(@Valid CreateInvoicesFormBean form,
                                       @RequestParam("invoiceDate") String invoiceDate) throws Exception{
        ModelAndView response = new ModelAndView();

        User user = securityServices.getSecureUser();

        LocalDate useInvoiceDate = LocalDate.parse(invoiceDate);

        for(String parentId : form.getInvoice()) {
            log.info("Checking: " + parentId );
            Parent parent = parentDao.findById(Integer.valueOf(parentId));
            List<Child> children = childDao.findByParentId(Integer.valueOf(parentId));
            invoiceWriter.writeInvoice(user, parent, children,useInvoiceDate);
        }

        response.setViewName("redirect:/user/createInvoice");
        return response;
    }


}
