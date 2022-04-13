package teksystems.casestudy.database.dao;

import teksystems.casestudy.database.entitymodels.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRoles, Long>{

    List<UserRoles> findByUserId(@Param("id") Integer id);
}

