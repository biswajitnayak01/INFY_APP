package com.infosys.app.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="bookingDetails")
public class BookingDetails {
	@Id
	@Column(name="bookingDetailsId")
	private String bookingDetailsId;
	@Column(name="bookingDates")
	private String bookingDates;
	@Column(name="customerName")
	private String customerName;
	@Column(name="customerEmail")
	private String customerEmail;
	@Column(name="customerMobile")
	private String customerMobile;
	@OneToOne
	@JoinColumn(name="roomId")
	private Rooms rooms;
	public Rooms getRooms() {
		return rooms;
	}
	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingDetailsId=" + bookingDetailsId + ", bookingDates=" + bookingDates
				+ ", customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerMobile="
				+ customerMobile + ", rooms=" + rooms + ", description=" + description + "]";
	}
	public String getBookingDetailsId() {
		return bookingDetailsId;
	}
	public void setBookingDetailsId(String bookingDetailsId) {
		this.bookingDetailsId = bookingDetailsId;
	}
	public String getBookingDates() {
		return bookingDates;
	}
	public void setBookingDates(String bookingDates) {
		this.bookingDates = bookingDates;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="description")
	private String description;
	
}
