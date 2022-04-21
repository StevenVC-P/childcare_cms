package teksystems.casestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entitymodels.User;

@Service
public class SecurityServices {

    @Autowired
    private UserDAO userDao;

    public User getSecureUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDao.findByEmail(currentPrincipalName);
        return user;
    }
}
