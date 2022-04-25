package teksystems.casestudy.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.User;

import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class InvoiceWriter {

    ChildServices childServices = new ChildServices();

    @Autowired
    AgeGroupServices ageGroupServices;

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;

    public String writeInvoice(User user, Parent parent, List<Child> children, LocalDate date) throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter docWriter = null;
        initializeFonts();

        String stringDate = String.valueOf(date);
        String invoiceName = user.getUserName().substring(0,3) + parent.getPrimaryPhoneNumber().substring(3,4) + parent.getPrimaryContact().substring(0,3) + stringDate;

        try {
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream("src/main/webapp/pub/invoiceStorage/" + invoiceName + ".pdf"));
            doc.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            PdfContentByte cb = docWriter.getDirectContent();

            boolean beginPage = true;
            int y = 0;
            int total = 0;
            for (int i = 0; i < children.size(); i++) {
                if (beginPage) {
                    beginPage = false;
                    generateLayout(doc, cb);
                    generateHeader(doc, cb, user, parent, invoiceName, stringDate);
                    y = 615;
                }
                Integer price = generateDetail(cb, children.get(i), date, y, user);
                y = y - 15;
                total = total+price;
            }
            printTotal(cb,total);
//            printPageNumber(cb);
        } catch (Exception dex)
        {
            dex.printStackTrace();
        } finally
        {
            doc.close();
            if (docWriter != null)
            {
                docWriter.close();
            }
        }

        return invoiceName;
    }

    private void generateLayout(Document doc, PdfContentByte cb)  {

        try {
            cb.setLineWidth(1f);

            // Invoice Header box layout
            cb.rectangle(420,700,150,60);
            cb.moveTo(420,720);
            cb.lineTo(570,720);
            cb.moveTo(420,740);
            cb.lineTo(570,740);
            cb.moveTo(480,700);
            cb.lineTo(480,760);
            cb.stroke();

            // Invoice Header box Text Headings
            createHeadings(cb,422,743,"Contact Name");
            createHeadings(cb,422,723,"Invoice No.");
            createHeadings(cb,422,703,"Invoice Date");

            // Invoice Detail box layout
            cb.rectangle(20,50,550,600);
            cb.moveTo(20,630);
            cb.lineTo(570,630);
//            cb.moveTo(50,50);
//            cb.lineTo(50,650);
            cb.moveTo(120,50);
            cb.lineTo(120,650);
            cb.moveTo(330,50);
            cb.lineTo(330,650);
            cb.moveTo(500,50);
            cb.lineTo(500,650);
            cb.stroke();

            // Invoice Detail box Text Headings
//            createHeadings(cb,22,633,"Qty");
            createHeadings(cb,22,633,"Child Name");
            createHeadings(cb,122,633,"Birth Day");
            createHeadings(cb,332,633,"Age Group");
            createHeadings(cb,502,633,"Price");

            //add the images
            Image companyLogo = Image.getInstance("src/main/webapp/pub/images/generic_logo.jpeg");
            companyLogo.setAbsolutePosition(-5,640);
            companyLogo.scalePercent(20);
            doc.add(companyLogo);

        }

        catch (DocumentException dex){
            dex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void generateHeader(Document doc, PdfContentByte cb, User user, Parent parent,String invoiceName, String stringDate)  {

        try {

            createHeadings(cb,300,750, user.getDayCareName());
            createHeadings(cb,300,735, user.getEmail());
//            createHeadings(cb,200,720,"Address Line 2");
//            createHeadings(cb,200,705,"City, State - ZipCode");
//            createHeadings(cb,200,690,"Country");

            createHeadings(cb,482,743, parent.getPrimaryContact());
            createHeadings(cb,482,723,invoiceName);
            createHeadings(cb,482,703,stringDate);

        }

        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public Integer generateDetail(PdfContentByte cb, Child child, LocalDate date,int y, User user)  {
        DecimalFormat df = new DecimalFormat("0.00");
        log.info(String.valueOf(user));
        int childInvoiceAge = childServices.calculateAge(child.getBirthDate(), date);
        log.info(String.valueOf(childInvoiceAge));
        AgeGroup ageGroup = ageGroupServices.findAgeGroup(childInvoiceAge, user);

        try {

            createContent(cb,22,y, child.getChildName(), PdfContentByte.ALIGN_LEFT);
            createContent(cb,122,y, String.valueOf(child.getBirthDate()),PdfContentByte.ALIGN_LEFT);
            createContent(cb,498,y, String.valueOf(ageGroup.getAgeGroup()),PdfContentByte.ALIGN_RIGHT);
            createContent(cb,568,y, df.format(ageGroup.getCost()),PdfContentByte.ALIGN_RIGHT);

        }

        catch (Exception ex){
            ex.printStackTrace();
        }
        return ageGroup.getCost();
    }

    private void createHeadings(PdfContentByte cb, float x, float y, String text){
        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x,y);
        cb.showText(text.trim());
        cb.endText();
    }

    private void printTotal(PdfContentByte cb,int total) {
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            createContent(cb,498,52, "Total:",PdfContentByte.ALIGN_RIGHT);
            createContent(cb,568,52, df.format(total),PdfContentByte.ALIGN_RIGHT);
        }

        catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    private void printPageNumber(PdfContentByte cb){
//        cb.beginText();
//        cb.setFontAndSize(bfBold, 8);
//        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber+1), 570 , 25, 0);
//        cb.endText();
//
//        pageNumber++;
//
//    }

    private void createContent(PdfContentByte cb, float x, float y, String text, int align){
        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.showTextAligned(align, text.trim(), x , y, 0);
        cb.endText();

    }

    private void initializeFonts(){
        try {
            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
