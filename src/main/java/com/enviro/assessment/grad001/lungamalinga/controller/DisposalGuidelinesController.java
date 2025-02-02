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
    @GetMapping("/all")
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

    // save/ add new disposal guideline
    @PostMapping("/save/disposalguideline")
    public LinkedHashMap saveDisposalGuideline(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();

        try {
            int category_id = (int) body.get("category_id");
            String instructions = (String) body.get("instructions");
            // save data to to db disposal guidelines table
            disposalGuidelinesRepo.save(new DisposalGuidelines(null, category_id, instructions, timestamp.getFormattedNow()));
        } catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to create disposal guideline record");
            responseObject.put("full error message", e.getMessage());
            return responseObject;
        }
        responseObject.put("success", true);
        responseObject.put("message", "successfully created the record [disposal guideline] ");
        return responseObject;
    }

    @PostMapping("/update/disposalguideline")
    public LinkedHashMap updateDisposalGuidelineById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();
        int disposalId = 0;

        try {

            disposalId = (int) body.get("id");

//            check if id exists before proceeding
            if (!disposalGuidelinesRepo.existsById(disposalId)) {
                responseObject.put("success", false);
                responseObject.put("message", "Invalid Id.");
                return responseObject;
            }

            int categoryId = (int) body.get("category_id");
            String instructions = (String) body.get("instructions");

            // save/update record
            disposalGuidelinesRepo.save(new DisposalGuidelines(disposalId, categoryId, instructions, timestamp.getFormattedNow()));

        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to update");
            responseObject.put("full update error message", e.getMessage());
            return responseObject;
        }

        responseObject.put("success", true);
        responseObject.put("message", "Successfully updated record with Id " + disposalId);
        return responseObject;
    }
}






















