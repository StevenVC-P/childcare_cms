package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.User;

import java.util.List;
import java.util.Map;

public interface AgeGroupDAO extends JpaRepository<AgeGroup,Long> {

    public AgeGroup findById(@Param("id") Integer id);

    public List<AgeGroup> findByUserId(@Param("user_id") Integer user_id);

    public List<AgeGroup> findAll();

    @Query(value= "select * from age_groups" +
            " where user_id = :user_id" +
           " order by age;", nativeQuery = true)
    List<AgeGroup> getAgeGroupsInOrder(@Param("user_id") Integer user_id);
}
