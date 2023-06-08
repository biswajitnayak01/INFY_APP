package com.infosys.app.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.app.Repository.RoomRepository;
import com.infosys.app.Repository.RoomTypeRepository;
import com.infosys.app.dto.RoomPriceTypeDto;
import com.infosys.app.dto.TypeDto;
import com.infosys.app.entity.RoomType;
import com.infosys.app.entity.Rooms;
import com.infosys.app.service.RoomsService;

@Service
public class RoomsServiceImpl implements RoomsService {
	Logger logger = LoggerFactory.getLogger(RoomsServiceImpl.class);

	@Autowired
	RoomRepository repo;
	@Autowired
	RoomTypeRepository roomtyperepo;

	@Override
	public List<RoomPriceTypeDto> fetchAllRoomData() {
		try {
		
		List<Rooms> roomData = repo.findAll();
		//boolean isActive = roomData.stream().allMatch(data -> data == null);
		//if (isActive)
		//	throw new NullPointerException("null value is found in fetchAllRoomData mehod() kindly check once");
		List<RoomPriceTypeDto> dataValue = roomData.stream().map(data -> {
			RoomPriceTypeDto rpto = new RoomPriceTypeDto();
		//	TypeDto td= new TypeDto();
			String roomid=data.getRoomId().toString();
			String price=data.getPrice().toString();
			rpto.setId(roomid);
			rpto.setPrice(price);
			rpto.setAmenties(data.getAmenties());
			rpto.setIsACAvailable(data.getIsACAvailable());
			rpto.setIsSmokingAvailable(data.getIsSmokingAvailable());
			rpto.setRoomtypedata(data.getRoomType().getRoomType());
			//td.setId(roomid);
			//td.setPrice(price);
			//td.setRoomtypedata(data.getRoomType().getRoomType());
			return rpto;
		}).collect(Collectors.toList());
		logger.info(
				" RoomsServiceImpl :fetchAllRoomData:  Rooms Table PRICE  ID  RoomType Data::" + dataValue.toString());
		return dataValue;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void addRoomDetails(String amenitiesjsonData, String formData) {
		try {
			// Gson gson = new Gson();
			// RequestData requestdata = gson.fromJson(amenitiesjsonData,
			// RequestData.class);
			// logger.info("data of value:::::::::" + requestdata.getIsACAvailable());
			/*
			 * room.setIsACAvailable(requestdata.getIsACAvailable());
			 * room.setIsSmokingAvailable(requestdata.getIsSmokingAvailable());
			 * room.setAmenties(amenitiesjsonData);
			 * room.setRoomId(requestdata.getRoomType());
			 */
			Map<String, String> mapvalue = new HashMap<>();
			String[] keyValuePairs = formData.split("&");

			for (String keyValuePair : keyValuePairs) {
				String[] keyValue = keyValuePair.split("=");
				mapvalue.put(keyValue[0], keyValue[1]);
			}
			logger.info("Add costumer Map Value:::RoomsServiceImpl::: value:::" + mapvalue);
			String pricedata = mapvalue.get("price");
			RoomType roomType = roomtyperepo.findByRoomType(mapvalue.get("roomtype"));
			Rooms room = new Rooms();
			room.setIsACAvailable(mapvalue.get("isACRoom"));
			room.setIsSmokingAvailable(mapvalue.get("SmokingAvailable"));
			room.setAmenties(amenitiesjsonData);
			room.setPrice(Integer.parseInt(pricedata));
			room.setRoomType(roomType);
			repo.save(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
