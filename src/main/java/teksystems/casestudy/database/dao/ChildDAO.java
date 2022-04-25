package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.casestudy.database.entitymodels.Child;

import java.util.List;

public interface ChildDAO extends JpaRepository<Child,Long> {

    public Child findById(@Param("id") Integer id);

    public List<Child> findByParentId(@Param("parent_id") Integer parent_id);

//    @Query(value=" select c.id as agegroup_id" +
//            "from children c"+
//            "where", nativeQuery=true)
//    List<Map<String,Object>> get

//    select p.id as product_id, p.name, p.price, op.quantity, o.id as order_id, (price * quantity) as total
//    from products p, order_products op, orders o
//    where p.id = op.product_id and o.id = op.order_id
//    and o.user_id = 1 and status = "PENDING";

}
