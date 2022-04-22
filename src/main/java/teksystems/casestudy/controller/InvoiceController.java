package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.dao.ChildDAO;
import teksystems.casestudy.database.dao.InvoiceDAO;
import teksystems.casestudy.database.dao.ParentDAO;
import teksystems.casestudy.database.entitymodels.*;
import teksystems.casestudy.formbean.CreateInvoicesFormBean;
import teksystems.casestudy.services.InvoiceWriter;
import teksystems.casestudy.services.SecurityServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import java.time.LocalDate;
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
    private ChildDAO childDao;

    @Autowired
    public InvoiceWriter invoiceWriter;

    @Autowired
    SecurityServices securityServices;

    @GetMapping("/user/invoice")
    public ModelAndView invoice() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/invoice");

        User user = securityServices.getSecureUser();
        List<Invoice> invoices = invoiceDAO.findByUserId(user.getId());
        response.addObject("invoices", invoices);

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

        String[] formInvoice = form.getInvoice();
        for (int i = 0; i < formInvoice.length; i++) {
            String parentId = formInvoice[i];

            Parent parent = parentDao.findById(Integer.valueOf(parentId));
            List<Child> children = childDao.findByParentId(Integer.valueOf(parentId));
            String invoiceNumber = invoiceWriter.writeInvoice(user, parent, children, useInvoiceDate);

            Invoice invoice = new Invoice();
            invoice.setInvoiceNumber(invoiceNumber);
            invoice.setInvoiceDate(useInvoiceDate);
            invoice.setUser(user);

            invoiceDAO.save(invoice);
        }

        response.setViewName("redirect:/user/createInvoice");
        return response;
    }

//    @GetMapping("/user/getInvoice/")
//    public ModelAndView getInvoice(@RequestParam("invoice") String invoice) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        response.setViewName("user/invoice");
//        return response;
//    }

    @GetMapping("/Export/PrintPdf/{invoice}")
    public ResponseEntity<Resource> downloadPdf(@PathVariable("invoice") String invoice, HttpServletRequest request) throws Exception {
        log.info(String.valueOf(request));
        log.info(invoice);
        return null;
    }
}
