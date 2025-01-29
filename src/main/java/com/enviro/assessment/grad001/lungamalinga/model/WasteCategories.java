package com.enviro.assessment.grad001.lungamalinga.model;

import org.springframework.data.annotation.Id;

public record WasteCategories(@Id Integer category_id,
                              String name,
                              String description,
                              String created_at){
}
