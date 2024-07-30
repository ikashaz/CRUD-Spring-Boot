package net.java.springboot_backend.repository;

import net.java.springboot_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User, Long> {
    //all crud database method
}
