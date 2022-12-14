package com.oracle.ohTravel.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.ohTravel.hotel.dao.HotelDAO;
import com.oracle.ohTravel.hotel.model.HotelDTO;
import com.oracle.ohTravel.hotel.model.HotelReservationDTO;
import com.oracle.ohTravel.hotel.model.RoomDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

	private final HotelDAO hd;
	
	@Override
	public List<HotelDTO> hotelList(HotelDTO hoteldto) {
		return hd.hotelList(hoteldto);
	}

	@Override
	public HotelDTO getHotelDetail(HotelDTO hotelDTO) {
		return hd.getHotelDetail(hotelDTO);
	}

	@Override
	public List<RoomDTO> getRoomList(RoomDTO roomDTO) {
		return hd.getRoomList(roomDTO);
	}

	@Override
	public RoomDTO getRoomDetail(RoomDTO roomDTO) {
		return hd.getRoomDetail(roomDTO);
	}

	@Override
	public String reserveHotel(HotelReservationDTO hotelRDTO) {
		
		try {
			
			for(int i = 0; i < hotelRDTO.getCalDate(); i++) {
				 hotelRDTO.setIntervalDay(i);
				 hd.updateReserveStat(hotelRDTO); 
				 //insert hotel_reservation 
				 hd.insertReserveInfo(hotelRDTO);
				 //inset payment 
				 hd.insertPayment(hotelRDTO);
			 }
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "FAILED";
		}
		 
		return "SUCCESS";
	}

	@Override
	public String getMembershipInfo(String mem_id) {
		return hd.getMembershipInfo(mem_id);
	}

}
