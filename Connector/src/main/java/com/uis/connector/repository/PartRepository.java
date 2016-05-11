package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Part;

@Repository
public interface PartRepository extends CrudRepository<Part, Long>{

}
