package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;

import com.uis.connector.entity.DatabaseVersion;

public interface DatabaseVersionRepository extends CrudRepository<DatabaseVersion, Integer>{

}
