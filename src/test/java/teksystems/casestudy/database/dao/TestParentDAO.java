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
import teksystems.casestudy.database.entitymodels.User;

import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestParentDAO {

    @Autowired
    private ParentDAO parentDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveParent(){
        Parent expected = new Parent();
        expected.setPrimaryContact("Karen");
        expected.setPrimaryPhoneNumber("555-6789");

        parentDAO.save(expected);

        Assertions.assertThat(expected.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getParentTest() {
        Parent parent = parentDAO.findById(1);
        Assertions.assertThat(parent.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOffParentsTest() {
        List<Parent> expected = parentDAO.findAll();
        Assertions.assertThat(expected.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updatePrimaryContactTest() {
        Parent expected = parentDAO.findById(1);
        expected.setPrimaryContact("Karen Johnson");
        Assertions.assertThat(parentDAO.findById(1).getPrimaryContact()).isEqualTo(expected.getPrimaryContact());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteParentTest() {
        Parent expected = parentDAO.findById(1);
        parentDAO.delete(expected);

        Optional<Parent> optionalParent = Optional.ofNullable(parentDAO.findById(expected.getId()));

        Parent tempParent = null;
        if(optionalParent.isPresent()) {
            tempParent = optionalParent.get();
        }

        Assertions.assertThat(tempParent).isNull();
    }
}