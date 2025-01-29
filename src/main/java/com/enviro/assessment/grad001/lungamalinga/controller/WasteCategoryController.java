package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.WasteCategories;
import com.enviro.assessment.grad001.lungamalinga.repo.WasteCategoryRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("get/wastecategories")
public class WasteCategoryController {
    private final WasteCategoryRepo wasteCategoryRepo;

    public WasteCategoryController( WasteCategoryRepo wasteCategoryRepo){
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    // GET ALL WASTE CATEGORIES
    @GetMapping
    public Iterable<WasteCategories> getAllWasteCategories(){
        return wasteCategoryRepo.findAll();
    }
}
