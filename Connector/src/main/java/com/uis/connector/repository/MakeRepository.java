package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Make;

@Repository
public interface MakeRepository extends CrudRepository<Make, Long>{

}
