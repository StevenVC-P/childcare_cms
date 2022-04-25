package teksystems.casestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

@Component
public class ChildServices {


    public int calculateAge(LocalDate birthday, LocalDate currentDate) {
        int months = Period.between(birthday, currentDate).getMonths();
        int years = Period.between(birthday, currentDate).getYears();
        return months+years*12;
    }

}
