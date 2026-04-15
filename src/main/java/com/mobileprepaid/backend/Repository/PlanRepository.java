package com.mobileprepaid.backend.Repository;

import com.mobileprepaid.backend.Model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByOperator(String operator);
}