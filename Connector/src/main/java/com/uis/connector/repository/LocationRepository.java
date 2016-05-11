package com.uis.connector.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Locations;

@Repository
public interface LocationRepository extends CrudRepository<Locations, Long>{

	@Query("select l.locationDetail from Locations l where serial = ?")
	String findLocationDetail(long id);
}
