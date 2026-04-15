package com.mobileprepaid.backend.Controller;

import com.mobileprepaid.backend.Model.Plan;
import com.mobileprepaid.backend.Repository.PlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin("*")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/{operator}")
    public List<Plan> getPlans(@PathVariable String operator) {
        return planRepository.findByOperator(operator);
    }
}