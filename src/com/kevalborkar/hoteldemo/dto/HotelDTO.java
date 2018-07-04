package com.kevalborkar.hoteldemo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="hotel_table")
public class HotelDTO implements Serializable{
	
	@Id
	@GenericGenerator(name="myId" , strategy="increment")
	@GeneratedValue(generator="myId")
	@Column(name="h_id")
	private int id;
	
	@Column(name="h_name")
	private String hotelName;
	
	@Column(name="room_price")
	private double roomPrice;
	
	@Column(name="room_name")
	private String roomName;
	
	@Column(name="h_addr")
	private String hotelAddr;
	
	public HotelDTO() {
		System.out.println("HotelDTO object created!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getHotelAddr() {
		return hotelAddr;
	}

	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}

	@Override
	public String toString() {
		return "HotelDTO [id=" + id + ", hotelName=" + hotelName + ", roomPrice=" + roomPrice + ", roomName=" + roomName
				+ ", hotelAddr=" + hotelAddr + "]";
	}
	
	
}
