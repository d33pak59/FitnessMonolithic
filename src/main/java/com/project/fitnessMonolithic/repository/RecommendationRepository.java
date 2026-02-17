package com.project.fitnessMonolithic.repository;

import com.project.fitnessMonolithic.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
}
