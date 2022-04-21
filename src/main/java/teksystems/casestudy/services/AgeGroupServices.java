package teksystems.casestudy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class AgeGroupServices implements Comparable<AgeGroup> {

    SecurityServices securityServices = new SecurityServices();

    private final AgeGroupDAO ageGroupDao;

    public AgeGroupServices(SecurityServices securityServices, AgeGroupDAO ageGroupDao) {
        this.securityServices = securityServices;
        this.ageGroupDao = ageGroupDao;
    }

    public AgeGroup findAgeGroup(int age, User user) {
        List<AgeGroup> listAgeGroup = orderAgeGroup(user);

        for (AgeGroup ageGroup : listAgeGroup) {

            if (age > ageGroup.getAge()) {
                break;
            } else if (age <= ageGroup.getAge()) {
                return ageGroup;
            } else {
                return null;
            }
        }

        return null;
    }

    private List<AgeGroup> orderAgeGroup (User user){
        log.info(String.valueOf(user));
        List<AgeGroup> listAgeGroup = ageGroupDao.findByUserId(user.getId());
        Collections.sort(listAgeGroup);

        return listAgeGroup;
    }

    @Override
    public int compareTo(AgeGroup o) {
        return 0;
    }
}
