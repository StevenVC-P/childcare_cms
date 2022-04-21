package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FamilyFormBean {

    private Integer id;

    private String primaryContact;

    private String secondaryContact;

    private String email;

    private String phone;

    private String secondaryPhone;

    private String address;

    private String city;

    private String state;

    private String zip;
}
