package com.example.Register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Register.Enity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
