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
	@Query("update InventoryImages set wsSync=1 where inventorySerial = :id and imageNo = :imgNo")
	int updateWSSyncStatusByInvSerial(@Param("id") Long serial, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("update InventoryImages set wsSync=1 where stockSerial = :id and imageNo = :imgNo")
	int updateWSSyncStatusByStockSerial(@Param("id") Long serial, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("delete InventoryImages where inventorySerial = :id and imageNo = :imgNo")
	int deleteByInvSerialAndImgNo(@Param("id") Long serial, @Param("imgNo") Integer imgNo);
	
	@Modifying
	@Transactional
	@Query("delete InventoryImages where stockSerial = :id and imageNo = :imgNo")
	int deleteByStockSerialAndImgNo(@Param("id") Long serial, @Param("imgNo") Integer imgNo);
}