package spring.softgen.softlab.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.softgen.softlab.springboottutorial.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.active = :active")
    List<User> findActive(boolean active);
}
