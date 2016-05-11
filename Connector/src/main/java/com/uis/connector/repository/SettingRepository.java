package com.uis.connector.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uis.connector.entity.Settings;

@Repository
@Transactional
public interface SettingRepository extends CrudRepository<Settings, Integer>{

}
