package com.zyj.springboot.dao;

import com.zyj.springboot.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yujie_Zhao
 * @ClassName CityRepository
 * @Description TODO
 * @Date 2021/4/16  14:48
 * @Version 1.0
 **/
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {

}
