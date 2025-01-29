package com.enviro.assessment.grad001.lungamalinga.model;


import org.springframework.data.annotation.Id;

public record DisposalGuidelines(@Id int guideline_id,
                                 int category_id,
                                 String instructions,
                                 String created_at ){

}
