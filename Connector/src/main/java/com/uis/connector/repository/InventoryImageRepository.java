package com.uis.connector.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.InventoryImages;

@Repository
public interface InventoryImageRepository extends CrudRepository<InventoryImages, Long>{

	List<InventoryImages> findByInventorySerialOrderByImageNo(long inventorySerial);
	
	List<InventoryImages> findByInventorySerialAndImageNo(long inventorySerial, int imageNo);
	
	List<InventoryImages> findByStockSerial(long stockSerial);
	
	List<InventoryImages> findByStockSerialAndImageNo(long stockSerial, int imageNo);
	
	@Modifying
	@Transactional
	@Query("update InventoryImages invImg set wsSync = 1 where inventorySerial = :ids and imageNo = :imgNo")
	int updateWSSyncStatusByInvSerial(@Param("ids") Long serials, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("update InventoryImages invImg set wsSync = 1 where stockSerial = :ids and imageNo = :imgNo")
	int updateWSSyncStatusByStockSerial(@Param("ids") Long serials, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("delete InventoryImages invImg where inventorySerial = :ids and imageNo = :imgNo")
	int deleteByInvSerialAndImgNo(@Param("ids") Long serials, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("delete InventoryImages invImg where stockSerial = :ids and imageNo = :imgNo")
	int deleteByStockSerialAndImgNo(@Param("ids") Long serials, @Param("imgNo") Integer imgNo);
}
