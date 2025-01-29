package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTip;
import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/get/tips")
public class RecyclingTipController {
    private final RecyclingTipRepo tipRepo;

    public RecyclingTipController(RecyclingTipRepo tipRepo) {
        this.tipRepo = tipRepo;
    }

    // return/get all recycling tips
    @GetMapping
    public Iterable<RecyclingTip> getAllTips(){
        return tipRepo.findAll();
    }

    // TODO: START HERE... @PostMapping
}
