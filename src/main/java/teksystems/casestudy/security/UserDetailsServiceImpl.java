package teksystems.casestudy.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.dao.UserRolesDAO;
import teksystems.casestudy.database.entitymodels.User;
import teksystems.casestudy.database.entitymodels.UserRoles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    
    public static final Logger Log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDAO userDao;
    
    @Autowired
    private UserRolesDAO userRolesDao;
    
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        if( user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in the database");
        }

        List<UserRoles> userRole = userRolesDao.findByUserId(user.getId());

        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRole);

        // gets the encrypted password from the database
        String password = user.getPassword();


        return new org.springframework.security.core.userdetails.User(username, password,
                accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                springRoles);
}

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRoles> userRole) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRoles role : userRole) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        return authorities;
    }
}
