package com.infosys.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room_type")
public class RoomType {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="room_type_id")
private Integer roomTypeId;
@Column(name="room type")
private String roomType;
@Override
public String toString() {
	return "RoomType [roomTypeId=" + roomTypeId + ", roomType=" + roomType + "]";
}
public Integer getRoomTypeId() {
	return roomTypeId;
}
public void setRoomTypeId(Integer roomTypeId) {
	this.roomTypeId = roomTypeId;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
}
