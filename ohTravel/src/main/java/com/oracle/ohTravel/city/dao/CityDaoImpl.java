package com.oracle.ohTravel.city.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ohTravel.city.model.CityDTO;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CityDaoImpl implements CityDao {
	@Autowired
	private SqlSession session;
	
	private String namespace = "com.oracle.ohTravel.CityMapper.";
	
	@Override
	public List<CityDTO> selectCityByCountryId(Integer country_id) {
		log.info("CityDaoImpl selectCity() start...");
		List<CityDTO> list = session.selectList(namespace+"selectCity", country_id);
		log.info("CityDaoImpl selectCity() end...");
		return list;
	}
}