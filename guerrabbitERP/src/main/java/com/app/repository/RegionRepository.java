package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Region;


@Repository
public interface RegionRepository extends CrudRepository <Region, Long> 
{

}
