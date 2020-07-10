package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.Society;

@Repository
public interface SocietyRepository extends CrudRepository <Society, Long> 
{

}
