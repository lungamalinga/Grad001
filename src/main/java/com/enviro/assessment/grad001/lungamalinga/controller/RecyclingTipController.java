package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTips;
import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/tips")
public class RecyclingTipController {
    private final RecyclingTipRepo tipRepo;

    public RecyclingTipController(RecyclingTipRepo tipRepo) {
        this.tipRepo = tipRepo;
    }

    // GET all recycling tips
    @GetMapping("/all")
    public Iterable<RecyclingTips> getAllTips() {
        return tipRepo.findAll();
    }

    // GET one tip record by id
    @GetMapping("/{id}")
    public Object getTipById(@PathVariable Integer id){
        LinkedHashMap responseObject = new LinkedHashMap();

        Optional<RecyclingTips> foundTip = tipRepo.findById(id);
        if ( !foundTip.isPresent() ){
            responseObject.put("success", false);
            responseObject.put("message", "No record with id " + id);
            return responseObject;
        }

        return tipRepo.findById(id);

    }

    // DELETE a tip by id
    @PostMapping("/delete/tip")
    public LinkedHashMap removeTipById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        int tipId;
        try {
            tipId = (int) body.get("tip_id");

            if (tipRepo.existsById(tipId)){
                System.out.println( "Deleting Tip :: " + tipId);
                tipRepo.deleteById( tipId );
            } else {
                responseObject.put("success", false);
                responseObject.put("message", "Tip ID don't exists.");
                return responseObject;
            }
        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", e.getMessage());
            return responseObject;
        }
        responseObject.put("success", true);
        responseObject.put("message", "successfully deleted record ["+tipId+"]");
        return responseObject;
    }

    // create tip by id
    @PostMapping("/save/tip")
    public LinkedHashMap saveTip(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();

        try {
            int categoryId = (int) body.get("category_id");
            String tipDesc = (String) body.get("tip_description");
            // save data to to db tip table
            tipRepo.save(new RecyclingTips(null, categoryId, tipDesc, timestamp.getFormattedNow()));
        } catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to create tip record");
            responseObject.put("full error message", e.getMessage());
            return responseObject;
        }
        responseObject.put("success", true);
        responseObject.put("message", "successfully created the record [tip] ");
        return responseObject;
    }

    // existing update tip
    @PostMapping("/update/tip")
    public LinkedHashMap updateTipById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();
        int tipId = 0;

        try {

            tipId = (int) body.get("tip_id");

//            check if id exists before proceeding
            if (!tipRepo.existsById(tipId)) {
                responseObject.put("success", false);
                responseObject.put("message", "Invalid Id.");
                return responseObject;
            }

            int categoryId = (int) body.get("category_id");
            String tipDescription = (String) body.get("tip_description");

            // save/update record
            tipRepo.save(new RecyclingTips(tipId, categoryId, tipDescription, timestamp.getFormattedNow()));

        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to update");
            responseObject.put("full update error message", e.getMessage());
            return responseObject;
        }

        responseObject.put("success", true);
        responseObject.put("message", "Successfully updated record with Id " + tipId);
        return responseObject;
    }
}
