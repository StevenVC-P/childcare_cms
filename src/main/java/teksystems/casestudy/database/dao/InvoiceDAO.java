package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.Invoice;

import java.util.List;

public interface InvoiceDAO extends JpaRepository<Invoice, Long> {

    public Invoice findById(@Param("id") Integer id);

    public List<Invoice> findByUserId(@Param("user_id") Integer user_id);

}
