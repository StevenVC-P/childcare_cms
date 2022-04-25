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
import java.util.stream.Stream;

@Slf4j
@Service
public class AgeGroupServices implements Comparable<AgeGroup> {

    SecurityServices securityServices = new SecurityServices();

    private final AgeGroupDAO ageGroupDao;

    @Autowired
    public AgeGroupServices(SecurityServices securityServices, AgeGroupDAO ageGroupDao) {
        this.securityServices = securityServices;
        this.ageGroupDao = ageGroupDao;
    }

    public AgeGroup findAgeGroup(int age, User user) {
        List<AgeGroup> listAgeGroup = ageGroupDao.getAgeGroupsInOrder(user.getId());
        AgeGroup childsAgeGroup = null;
        log.info(String.valueOf(age));

        try {
            Stream<AgeGroup> filteredAgeGroup = listAgeGroup.stream().filter(a -> a.getAge() >= age);
            log.info(String.valueOf(filteredAgeGroup));

            for (AgeGroup ageGroup : (List<AgeGroup>) filteredAgeGroup) {
                log.info(String.valueOf(ageGroup.getAgeGroup()));
                if (age > ageGroup.getAge()) {
                    continue;
                } else if (age <= ageGroup.getAge()) {
                    childsAgeGroup = ageGroup;
                    break;
                }
            }

        } catch (Exception e) {
                e.getMessage();
                return null;
            }

        return childsAgeGroup;
    }

    public List<AgeGroup> orderAgeGroup (User user){
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
