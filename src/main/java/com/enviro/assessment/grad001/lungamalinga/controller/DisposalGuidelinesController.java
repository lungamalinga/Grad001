package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.DisposalGuidelines;
import com.enviro.assessment.grad001.lungamalinga.repo.DisposalGuidelinesRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("get/disposalguidelines")
public class DisposalGuidelinesController {
    private final DisposalGuidelinesRepo disposalGuidelinesRepo;

    public DisposalGuidelinesController( DisposalGuidelinesRepo disposalGuidelinesRepo ){
        this.disposalGuidelinesRepo = disposalGuidelinesRepo;
    }

    // GET ALL DISPOSAL GUIDELINES
    @GetMapping
    public Iterable<DisposalGuidelines> getAllDisposalGuidelines(){
        return disposalGuidelinesRepo.findAll();
    }
}
