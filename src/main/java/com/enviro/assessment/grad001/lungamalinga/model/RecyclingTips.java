package com.enviro.assessment.grad001.lungamalinga.model;

import org.springframework.data.annotation.Id;

/**
 * Using string data jdbc
 */
public record RecyclingTips(@Id Integer id,
                            Integer category_id,
                            String tip_description,
                            String created_at) {
}
