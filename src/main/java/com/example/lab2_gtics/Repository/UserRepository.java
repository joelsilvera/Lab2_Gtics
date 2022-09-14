package com.example.lab2_gtics.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab2_gtics.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
