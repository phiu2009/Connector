package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long>{

}
