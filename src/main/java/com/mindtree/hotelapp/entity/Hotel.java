package com.mindtree.hotelapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private short hotelId;
	private String hotelName;
	private String city;
	private Room rooms ;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(short hotelId, String hotelName, String city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}

	public Hotel(short hotelId, String hotelName, String city, Room rm) {
		// TODO Auto-generated constructor stub
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.rooms = rm;
	}

	public short getHotelId() {
		return hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getCity() {
		return city;
	}

	

	public void setHotelId(short hotelId) {
		this.hotelId = hotelId;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return String.format("Hotel [hotelId=%s, hotelName=%s, city=%s, rooms=%s]", hotelId, hotelName, city, rooms);
	}

	
}
