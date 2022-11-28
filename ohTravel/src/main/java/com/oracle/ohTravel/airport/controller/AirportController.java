package com.oracle.ohTravel.airport.controller;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.ohTravel.airport.model.AirSearch;
import com.oracle.ohTravel.airport.model.Air_ScheduleDTO;
import com.oracle.ohTravel.airport.service.ScheduleService;
import com.oracle.ohTravel.city.model.CityDTO;
import com.oracle.ohTravel.city.service.CityService;
import com.oracle.ohTravel.country.model.CountryDTO;
import com.oracle.ohTravel.country.service.CountryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/airport")
@Slf4j
public class AirportController {
	
	private final CityService cityService;
	private final CountryService countryService;
	private final ScheduleService scheduleService;
	
	//항공권 검색
	@RequestMapping(value = "/searchTicket")
	public String searchTicket(Model model) throws Exception {
		log.info("AirportController searchTicket");
		// 가고싶은 나라 country 모두 가져오기
		List<CountryDTO> countryList = countryService.selectCountryByCountryId(0);
				
		
		model.addAttribute("countryList",countryList);
		
		return "airport/searchTicket";
	}
	
	//항공권 예약
	@RequestMapping(value = "/air_reservation")
	public String air_reservation() {
		return "airport/air_reservation";
	}
	
	//도시불러오는 메서드
	@PostMapping("/selectCity")
	@ResponseBody
	public List<CityDTO> selectCity(Integer country_id) throws Exception {
		log.info("AirportController selectCity() start...");
		List<CityDTO> list = cityService.selectCityByCountryId(country_id);
		log.info("AirportController selectCity() end...");
		return list;
	}
	
	@PostMapping("/searchAirplane")
	public ModelAndView searchAirplane(AirSearch airSearch) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Air_ScheduleDTO> schedule_list = scheduleService.searchAirplane(airSearch);
		System.out.println("schedule_list="+schedule_list);
		System.out.println("airSearch="+airSearch);
		
		mav.setViewName("search/searchResultAirplane");
		mav.addObject("schedule_list",schedule_list);
		mav.addObject("seat_position",airSearch.getSeat_position());
		return mav;
	}
	
	
	
}
