package com.uis.connector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Series;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Long>{

}
