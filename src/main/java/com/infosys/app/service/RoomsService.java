package com.infosys.app.service;
import java.util.List;
import com.infosys.app.dto.RoomPriceTypeDto;
import com.infosys.app.dto.TypeDto;
public interface RoomsService {
public List<RoomPriceTypeDto> fetchAllRoomData();
public void addRoomDetails(String amenitiesjsonData, String formData);
}
