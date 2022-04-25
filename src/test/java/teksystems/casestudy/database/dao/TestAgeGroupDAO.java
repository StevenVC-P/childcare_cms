package teksystems.casestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;

//@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestAgeGroupDAO {

    @Autowired
    private AgeGroupDAO ageGroupDAO;

    @Autowired
    private UserDAO userDAO;

    static User user;

    @BeforeAll
    public static void setUp() {
        user = User.builder().userName("Chad").email("hotboy@hotmail.com").password("IAMSTUPID").dayCareName("StillAChild").build();
    }

    @ParameterizedTest
    @Rollback(value = false)
    @CsvSource({"Baby, 16, 225"})
    public void createAgeGroupTest(String ageGroup, Integer age, Integer cost) {
        userDAO.save(user);
        AgeGroup expected = new AgeGroup();

        expected.setAgeGroup(ageGroup);
        expected.setAge(age);
        expected.setCost(cost);
        expected.setUser(user);

        AgeGroup result = ageGroupDAO.save(expected);

        Assertions.assertEquals(ageGroup, result.getAgeGroup());
    }
}
