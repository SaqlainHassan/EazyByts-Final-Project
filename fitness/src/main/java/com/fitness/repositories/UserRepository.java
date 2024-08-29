package com.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
