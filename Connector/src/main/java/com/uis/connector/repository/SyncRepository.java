package com.uis.connector.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.ConnectorSync;

@Repository
public interface SyncRepository extends CrudRepository<ConnectorSync, Integer>{

	@Modifying
	@Transactional
	@Query("update connector_sync set version = :newVersion where serial = 1")
	void updateVersion(@Param("newVersion") BigDecimal newVersion);
	
	@Modifying
	@Transactional
	@Query("update connector_sync set lastInventorySync=now(), lastStockSync=now() where serial = 1")
	void updateLastCheck();
	
	@Modifying
	@Transactional
	@Query("update connector_sync set lastInventorySync=now() where serial = 1")
	void updateLastInventoryCheck();
	
	@Modifying
	@Transactional
	@Query("update connector_sync set lastStockSync=now() where serial = 1")
	void updateLastStockCheck();
}
