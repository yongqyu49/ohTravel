package com.oracle.ohTravel.ticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.ohTravel.ticket.dao.TicketDAO;
import com.oracle.ohTravel.ticket.model.TicketDTO;
import com.oracle.ohTravel.ticket.model.TicketReservation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

	private final TicketDAO td;
	
	@Override
	public int totalTicket() {
		System.out.println("TicketServiceImpl Start total..." );
		int totTicketCnt = td.totalTicket();
		return totTicketCnt;
	}
	
	
	// 입장권 목록
	@Override
	public List<TicketDTO> ticketList(TicketDTO ticketdto) {
		System.out.println("~~ TicketServiceImpl ticketList Start ~~");
		return td.ticketList(ticketdto);
	}

	// 입장권 상세 정보
	@Override
	public TicketDTO getTicketDetail(String ticket_id) {
		System.out.println("~~ TicketServiceImpl getTicketDetail Start ~~");
		
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO = td.getTicketDetail(ticket_id);
		
		return ticketDTO;
	}

	// 입장권 찐예약
	@Override
	public void reserveExhibition(TicketReservation trDTO) {
		System.out.println("~~ TicketServiceImpl reserveExhibition Start ~~");
		
		trDTO.setTicket_puchase_date(new Date());
		td.reserveExhibition(trDTO);
	}



}
