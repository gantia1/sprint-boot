package spring.softgen.softlab.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.softgen.softlab.springboottutorial.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.deleted = :deleted")
    List<Customer> findNoDelete(boolean deleted);
}
