package com.uis.connector.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

	@Query("Select inv from Inventory inv where inv.status > -1 and inv.modifiedDateTime > :lastUpdate")
	List<Inventory> findByModifiedDateTimeGreaterThan(@Param("lastUpdate") LocalDateTime lastUpdate);
	
	@Query("Select inv from Inventory inv where inv.sold = 0 and inv.writeOff = 0 and inv.status > -1 and inv.deleted = 0")
	List<Inventory> findAllActiveInventory();
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set wsSync = 1 where serial in :ids")
	int updateWSSyncStatus(@Param("ids") List<Long> serials);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set sold = 1 where serial = :ids")
	int updateSoldStatus(@Param("ids") List<Long> serials);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set sold = 1 where serial = :id")
	int updateSoldStatus(@Param("id") Long serials);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set image1 = :data where serial = :ids")
	int updateInvImage1(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set image2 = :data where serial = :ids")
	int updateInvImage2(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set image3 = :data where serial = :ids")
	int updateInvImage3(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set image4 = :data where serial = :ids")
	int updateInvImage4(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Inventory inv set location = (select serial from Locations where location = :location) where serial = :id")
	int updateInvLocation(@Param("id") Long serials, @Param("location") String location);
}
