package com.example.bb2formacion.repository;

import com.example.bb2formacion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
