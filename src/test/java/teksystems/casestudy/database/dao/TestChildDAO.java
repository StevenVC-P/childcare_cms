package teksystems.casestudy.database.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import teksystems.casestudy.database.entitymodels.Parent;
import teksystems.casestudy.database.entitymodels.Child;
import teksystems.casestudy.database.entitymodels.User;

import java.time.LocalDate;

@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestChildDAO {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ParentDAO parentDAO;

    @Autowired
    private ChildDAO childDAO;


    @Test
    @Rollback(value = false)
    public void saveChild(){
        User user  = User.builder().userName("Chad").email("hotboy@hotmail.com").password("IAMSTUPID").dayCareName("StillAChild").build();
        userDAO.save(user);
        Parent parent = Parent.builder().primaryContact("Karen").primaryPhoneNumber("555-555").email("KarenS@gmail.com").address("110 North Street").city("Tuscon").state("AZ").zip("49823").user(user).build();
        parentDAO.save(parent);

        Child expected = Child.builder().childName("Billy").birthDate(LocalDate.parse("2020-05-15")).parent(parent).build();
        childDAO.save(expected);

        Assertions.assertThat(expected.getId()).isGreaterThan(0);
    }
}
