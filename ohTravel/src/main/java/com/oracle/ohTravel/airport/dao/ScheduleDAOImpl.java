package com.oracle.ohTravel.airport.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.ohTravel.airport.model.AirSearch;
import com.oracle.ohTravel.airport.model.Air_ScheduleDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ScheduleDAOImpl implements ScheduleDAO {
	
	private final SqlSession session;
	private String namespace = "com.oracle.ohTravel.AirportMapper.";

	@Override
	public List<Air_ScheduleDTO> airplaneList(AirSearch airSeach) {
		System.out.println("ScheduleDAOImpl airSeach="+airSeach);
		List<Air_ScheduleDTO> list = null;
		try {
			list = session.selectList(namespace + "airplaneList", airSeach);
			System.out.println("ScheduleDAOImpl airplaneList list=" + list);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
