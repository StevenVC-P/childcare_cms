package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.Parent;

public interface ParentDAO extends JpaRepository<Parent,Long> {

    public Parent findById(@Param("id") Integer id);
}
