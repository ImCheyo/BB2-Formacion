package com.example.bb2formacion.repository;

import com.example.bb2formacion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT nextval('user_code_seq')", nativeQuery = true)
    Integer getNextUserCode();

    Optional<User> getUserByUserCode(Integer userCode);
}
