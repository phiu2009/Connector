package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Gearbox;

@Repository
public interface GearboxRepository extends CrudRepository<Gearbox, Long>{

}
