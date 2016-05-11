package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Body;

@Repository
public interface BodyRepository extends CrudRepository<Body, Long>{

}
