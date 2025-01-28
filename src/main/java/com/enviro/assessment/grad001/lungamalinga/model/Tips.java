package com.enviro.assessment.grad001.lungamalinga.model;

import org.springframework.data.annotation.Id;

/**
 * Using string data jdbc
 */
public record Tips(@Id Integer id, String title, String description) {

}
