package com.infosys.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.app.beans.RequestBodydata;
import com.infosys.app.dto.RoomPriceTypeDto;
import com.infosys.app.exception.RoomTypeCostumException;
import com.infosys.app.service.RoomsService;

@RestController
public class RoomController {
	@Autowired
	RoomsService roomService;
	RoomsTypeController rc;
	Logger logger = LoggerFactory.getLogger(RoomController.class);
	/*
	 * @GetMapping("/addCostumer") public void bookCostumer(HttpServletResponse
	 * response, Model model) throws IOException { List<String> roomtypedata =
	 * rc.fetchRoomType();
	 * logger.info("phone number avaliabale here:::::::::::::::::" + roomtypedata);
	 * model.addAttribute("roomTypDatas", roomtypedata);
	 * response.sendRedirect("views/bookHotel.jsp"); }
	 */

	@GetMapping("/addCostumer")
	public String bookCostumer(Model model) {
		List<String> roomtypedata;
		try {
			roomtypedata = rc.fetchRoomType();
			logger.info("phone number avaliabale here:::::::::::::::::" + roomtypedata);
			model.addAttribute("roomTypDatas", roomtypedata);
		} catch (RoomTypeCostumException e) {
			e.printStackTrace();
		}

		return "bookHotel";
	}

	@PostMapping("/addRoomData")
	public ResponseEntity<String> addRoomData(@RequestBody RequestBodydata requestdata) {
		logger.info("inside addRoomData() @RequestBody VALUES:::::::::::::::::" + requestdata);
		roomService.addRoomDetails(requestdata.getAmenitiesjsonData(), requestdata.getFormData());
		return ResponseEntity.status(HttpStatus.OK).body("sucessfully added in DB");
	}
	@GetMapping(value = "/fetchAllRoooms", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoomPriceTypeDto>> fetchBookingDetails() {
		List<RoomPriceTypeDto> rpto = roomService.fetchAllRoomData();
		logger.info("fetchAllRoooms ::::::::::::::::::::::::::::::::::"+rpto);
		return ResponseEntity.ok(rpto);	
	}

	@GetMapping("/*")
	public String ErrorPage() {
		return "404 Error url not found,check url";
	}

}
