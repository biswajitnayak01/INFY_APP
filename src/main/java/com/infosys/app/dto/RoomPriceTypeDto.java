package com.infosys.app.dto;
import com.infosys.app.entity.RoomType;

import jakarta.persistence.Column;

public class RoomPriceTypeDto {
	private String price;
	private String id;
	private  RoomType roomtype;
	private  String  roomtypedata;
	private String isACAvailable;
	private String isSmokingAvailable;
	public String getIsACAvailable() {
		return isACAvailable;
	}
	public void setIsACAvailable(String isACAvailable) {
		this.isACAvailable = isACAvailable;
	}
	public String getIsSmokingAvailable() {
		return isSmokingAvailable;
	}
	public void setIsSmokingAvailable(String isSmokingAvailable) {
		this.isSmokingAvailable = isSmokingAvailable;
	}
	public String getAmenties() {
		return amenties;
	}
	public void setAmenties(String amenties) {
		this.amenties = amenties;
	}
	private String amenties;
	public String getRoomtypedata() {
		return roomtypedata;
	}
	public void setRoomtypedata(String roomtypedata) {
		this.roomtypedata = roomtypedata;
	}

	/*
	 * public RoomType getRoomtype() { return roomtype; } public void
	 * setRoomtype(RoomType roomtype) { this.roomtype = roomtype; }
	 */

	@Override
	public String toString() {
		return "RoomPriceTypeDto [price=" + price + ", id=" + id + ", roomtype=" + roomtype + ", roomtypedata="
				+ roomtypedata + ", isACAvailable=" + isACAvailable + ", isSmokingAvailable=" + isSmokingAvailable
				+ ", amenties=" + amenties + "]";
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RoomType getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}
	
}
