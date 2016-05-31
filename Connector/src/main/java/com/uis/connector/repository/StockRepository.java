package com.uis.connector.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{
	
	@Query("Select st from Stock st where st.modifiedDateTime > ?")
	List<Stock> findByModifiedDateTimeGreaterThan(LocalDateTime lastUpdate);
	
	@Query("Select st from Stock st where st.deleted = 0 and st.writeOff = 0")
	List<Stock> findAllActiveStock();
	
	@Modifying
	@Transactional
	@Query("update Stock st set wsSync = 1 where serial in :ids")
	int updateWSSyncStatus(@Param("ids") List<Long> serials);
	
	@Modifying
	@Transactional
	@Query("update Stock  set image1 = :data where serial = :ids")
	int updateImage1(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Stock  set image2 = :data where serial = :ids")
	int updateImage2(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Stock  set image3 = :data where serial = :ids")
	int updateImage3(@Param("ids") Long serials, @Param("data") String imageData);
	
	@Modifying
	@Transactional
	@Query("update Stock  set image4 = :data where serial = :ids")
	int updateImage4(@Param("ids") Long serials, @Param("data") String imageData);
}
