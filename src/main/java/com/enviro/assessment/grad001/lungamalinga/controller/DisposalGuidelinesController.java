package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.DisposalGuidelines;
import com.enviro.assessment.grad001.lungamalinga.repo.DisposalGuidelinesRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/disposalguidelines")
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

    // GET ONE Disposal guideline by id
    @GetMapping("/{id}")
    public Object getDisposalGuideline(@PathVariable Integer id){
        LinkedHashMap responseObject = new LinkedHashMap();

        Optional<DisposalGuidelines> foundDisposalGuide = disposalGuidelinesRepo.findById(id);
        if(!foundDisposalGuide.isPresent()){
            responseObject.put("success", false);
            responseObject.put("message", "Disposal guideline not found with Id: " + id);
            return responseObject;
        }

        return  disposalGuidelinesRepo.findById(id);
    }
}
