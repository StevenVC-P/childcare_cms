package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ChildFormBean {

    private Integer id;

    private String firstName;

    private String lastName;

    private Date birthDay;
}
