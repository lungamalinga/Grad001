package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.DisposalGuidelines;
import com.enviro.assessment.grad001.lungamalinga.repo.DisposalGuidelinesRepo;
import org.springframework.web.bind.annotation.*;

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

    // DELETE DISPOSAL GUIDELINE BY ID
    @PostMapping("/delete/disposalguideline")
    public LinkedHashMap removeDisposalGuidelineById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap( );
        int disposalId;

        try {
            disposalId = (int) body.get("id");
            if ( disposalGuidelinesRepo.existsById(disposalId) ){
                System.out.println( "Deleting Tip :: " + disposalId);
                disposalGuidelinesRepo.deleteById( disposalId );
            } else {
                responseObject.put("success", false);
                responseObject.put("message", "Disposal guideline ID don't exists.");
                return responseObject;
            }

        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", e.getMessage());
            return responseObject;
        }

        responseObject.put("success", true);
        responseObject.put("message", "successfully deleted record ["+disposalId+"]");
        return responseObject;

    }
}
