package com.mindtree.hotelapp.entity;

public class Room {
	private short roomId;
	private String roomType;
	private float price;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(short roomId, String roomType, float price) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
	}


	public short getRoomId() {
		return roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public float getPrice() {
		return price;
	}

	public void setRoomId(short roomId) {
		this.roomId = roomId;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Room [roomId=%s, roomType=%s, price=%s]", roomId, roomType, price);
	}
	
	
	
}
