package com.infosys.app.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Rooms {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(generator = "custom_id")
	// @GenericGenerator(name="custom_id",strategy=
	// "com.infosys.app.CustomGenerator")
	@Column(name = "roomId")
	private Integer roomId;
	@Column(name = "price")
	private Integer price;

	@Column(name = "isACAvailable")
	private String isACAvailable;
	@Column(name = "isSmokingAvailable")
	private String isSmokingAvailable;
	@Column(name = "amenties", columnDefinition = "TEXT")
	private String amenties;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	private RoomType roomType;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Rooms [roomId=" + roomId + ", price=" + price + ", isACAvailable=" + isACAvailable
				+ ", isSmokingAvailable=" + isSmokingAvailable + ", amenties=" + amenties + ", roomType=" + roomType
				+ "]";
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

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

}
