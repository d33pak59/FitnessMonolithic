package com.project.fitnessMonolithic.repository;

import com.project.fitnessMonolithic.model.Activity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
