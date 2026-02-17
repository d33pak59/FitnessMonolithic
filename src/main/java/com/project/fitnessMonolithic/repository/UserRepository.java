package com.project.fitnessMonolithic.repository;

import com.project.fitnessMonolithic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
