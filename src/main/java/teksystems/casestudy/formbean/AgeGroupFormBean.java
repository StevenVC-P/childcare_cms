package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AgeGroupFormBean {

    private Integer id;

    private String ageGroup;

    private Integer age;

    private String period;

    private Integer cost;
}
