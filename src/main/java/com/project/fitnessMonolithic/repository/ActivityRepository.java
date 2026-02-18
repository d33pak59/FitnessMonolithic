package com.project.fitnessMonolithic.repository;

import com.project.fitnessMonolithic.dto.ActivityResponseDTO;
import com.project.fitnessMonolithic.model.Activity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    List<Activity>findByUserInfo( Long userInfo);
}