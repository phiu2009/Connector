package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Trim;

@Repository
public interface TrimRepository extends CrudRepository<Trim, Long>{

}
