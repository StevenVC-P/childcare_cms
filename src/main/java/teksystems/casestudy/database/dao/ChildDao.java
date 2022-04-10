package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.Child;

import java.util.List;

public interface ChildDao extends JpaRepository<Child,Long> {

    public Child findById(@Param("id") Integer id);

    public List<Child> findByParentId(@Param("parent_id") Integer parent_id);
}
