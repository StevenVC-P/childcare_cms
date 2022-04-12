package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.AgeGroup;

import java.util.List;

public interface AgeGroupDAO extends JpaRepository<AgeGroup,Long> {

    public AgeGroup findById(@Param("id") Integer id);

    public List<AgeGroup> findByUserId(@Param("user_id") Integer user_id);

    public List<AgeGroup> findAll();
}
