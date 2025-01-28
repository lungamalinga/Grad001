package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.Tips;
import com.enviro.assessment.grad001.lungamalinga.repo.TipRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/get/tips")
public class TipController {
    private final TipRepo tipRepo;

    public TipController(TipRepo tipRepo) {
        this.tipRepo = tipRepo;
    }

    // return/get all recycling tips
    @GetMapping
    public Iterable<Tips> getAllTips(){
        return tipRepo.findAll();
    }
}
