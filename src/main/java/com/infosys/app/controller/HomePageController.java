package com.infosys.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.infosys.app.dto.RoomPriceTypeDto;
import com.infosys.app.entity.RoomType;
import com.infosys.app.service.RoomTypeService;
import com.infosys.app.service.RoomsService;
@Controller
public class HomePageController {
	@Autowired
	RoomTypeService rs;
	@Autowired
	RoomsService repo;
	Logger logger= LoggerFactory.getLogger(HomePageController.class);
@GetMapping("/homepage")
public String homeCall(Model model) {
	List<RoomType>rtype=rs.getRoomDeatils();
	List<String>roomtypedata=rtype.stream().map(RoomType::getRoomType).collect(Collectors.toList());
	model.addAttribute("roomTypData",roomtypedata);
	List<RoomPriceTypeDto>PriceType =repo.fetchAllRoomData();
	model.addAttribute("PriceType",PriceType);
	logger.info("fetching roomType Data from Dynamic DB:::"+roomtypedata);
	return "home";
}
@GetMapping("/UpdatePage")
public String editDeleteRenderUrl() {
	logger.info("HomePageController:: editDeleteRenderUrl() :: EditDeleteRoom :: Rendering page");
	return "EditDeleteRoom";
}
@GetMapping(value = "/deleteroomdetails/{roomid}")
public String deleteRoomData(@PathVariable("roomid")String roomId) {
	logger.info("DeleteRoomDetails DeleteRoomDetails:::::::::::"+roomId);
	return "DeletePage";
}
}
