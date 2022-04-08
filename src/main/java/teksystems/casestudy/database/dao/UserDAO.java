package teksystems.casestudy.database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entitymodels.User;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);
}
