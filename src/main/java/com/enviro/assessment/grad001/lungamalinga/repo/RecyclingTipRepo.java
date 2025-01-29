package com.enviro.assessment.grad001.lungamalinga.repo;

import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTips;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJdbcRepositories
public interface RecyclingTipRepo extends CrudRepository<RecyclingTips, Integer> {

}
