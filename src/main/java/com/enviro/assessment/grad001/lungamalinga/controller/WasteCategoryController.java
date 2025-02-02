package com.enviro.assessment.grad001.lungamalinga.controller;

import com.enviro.assessment.grad001.lungamalinga.model.WasteCategories;
import com.enviro.assessment.grad001.lungamalinga.repo.WasteCategoryRepo;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/wastecategories")
public class WasteCategoryController {
    private final WasteCategoryRepo wasteCategoryRepo;

    public WasteCategoryController( WasteCategoryRepo wasteCategoryRepo){
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    // GET ALL WASTE CATEGORIES
    @GetMapping("/all")
    public Iterable<WasteCategories> getAllWasteCategories(){
        return wasteCategoryRepo.findAll();
    }

    // GET ONE WASTE CATEG. by id
    @GetMapping("/{id}")
    public Object getWasteCategoryById(@PathVariable Integer id){
        LinkedHashMap responseObject = new LinkedHashMap();

        Optional<WasteCategories> foundWasteCategory = wasteCategoryRepo.findById(id);
        if ( !foundWasteCategory.isPresent() ){
            responseObject.put("success", false);
            responseObject.put("message", "No record with id " + id);
            return responseObject;
        }
        return wasteCategoryRepo.findById(id);
    }

    // DELETE A CATEGORY BY ID
    @PostMapping("/delete/wastecategory")
    public LinkedHashMap removeWasteCategoryById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        int wasteCatId;
        try {
            wasteCatId = (int) body.get("id");

            if (wasteCategoryRepo.existsById(wasteCatId)){
                System.out.println( "Deleting Waste Category :: " + wasteCatId);
                wasteCategoryRepo.deleteById( wasteCatId );
            } else {
                responseObject.put("success", false);
                responseObject.put("message", "Waste category ID don't exists.");
                return responseObject;
            }
        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", e.getMessage());
            return responseObject;
        }
        responseObject.put("success", true);
        responseObject.put("message", "successfully deleted record ["+wasteCatId+"]");
        return responseObject;
    }

    // create a waste category by id
    @PostMapping("/save/wastecategory")
    public LinkedHashMap saveWasteCategory(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();

        try {
            String name = (String) body.get("name");
            String description = (String) body.get("description");
            // save data to to db
            wasteCategoryRepo.save(new WasteCategories(null, name, description, timestamp.getFormattedNow()));
        } catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to create waste category record");
            responseObject.put("full error message", e.getMessage());
            return responseObject;
        }
        responseObject.put("success", true);
        responseObject.put("message", "successfully created the record [waste category] ");
        return responseObject;
    }

    // update waste category
    @PostMapping("/update/wastecategory")
    public LinkedHashMap updateWasteCategoryById(@RequestBody LinkedHashMap body){
        LinkedHashMap responseObject = new LinkedHashMap();
        TimeController timestamp = new TimeController();
        int wasteCatId = 0;

        try {

            wasteCatId = (int) body.get("id");

//            check if id exists before proceeding
            if (!wasteCategoryRepo.existsById(wasteCatId)) {
                responseObject.put("success", false);
                responseObject.put("message", "Invalid Id.");
                return responseObject;
            }

            String name = (String) body.get("name");
            String description = (String) body.get("description");

            // save/update record
            wasteCategoryRepo.save(new WasteCategories(wasteCatId, name, description, timestamp.getFormattedNow()));

        }catch (Exception e){
            responseObject.put("success", false);
            responseObject.put("message", "Failed to update");
            responseObject.put("full update error message", e.getMessage());
            return responseObject;
        }

        responseObject.put("success", true);
        responseObject.put("message", "Successfully updated record with Id " + wasteCatId);
        return responseObject;
    }
}
