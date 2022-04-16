package teksystems.casestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import teksystems.casestudy.database.dao.AgeGroupDAO;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;

import java.util.Collections;
import java.util.List;

public class AgeGroupServices implements Comparable<AgeGroup> {

    SecurityServices securityServices = new SecurityServices();

    @Autowired
    private AgeGroupDAO ageGroupDao;

//    public List<AgeGroup> orderAgeGroup (){
//        User user = securityServices.getSecureUser();
//        List<AgeGroup> listAgeGroup = ageGroupDao.findByUserId(user.getId());
//        Collections.sort(listAgeGroup);
//
//        return listAgeGroup;
//    }

    @Override
    public int compareTo(AgeGroup o) {
        return 0;
    }
}
