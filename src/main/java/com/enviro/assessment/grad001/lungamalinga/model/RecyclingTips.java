package com.enviro.assessment.grad001.lungamalinga.model;

import org.springframework.data.annotation.Id;

/**
 * Using string data jdbc
 */
public record RecyclingTips(@Id Integer tip_id,
                            String category_id,
                            String tip_description,
                            String created_at) {
}


//tip_id int auto_increment PRIMARY KEY not null,
//category_id int not null,
//tip_description varchar(255) not null,
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,