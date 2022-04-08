package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entitymodels.AgeGroup;
import teksystems.casestudy.database.entitymodels.Parent;

public interface AgeGroupDAO extends JpaRepository<AgeGroup,Long> {


}
