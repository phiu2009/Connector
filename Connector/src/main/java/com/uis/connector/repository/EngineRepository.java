package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Engine;

@Repository
public interface EngineRepository extends CrudRepository<Engine, Long>{

}
