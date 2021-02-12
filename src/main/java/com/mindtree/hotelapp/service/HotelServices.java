package com.mindtree.hotelapp.service;

import com.mindtree.hotelapp.entity.Room;
import com.mindtree.hotelapp.exception.serviceexception.HotelCitynotfoundservice;
import com.mindtree.hotelapp.exception.serviceexception.HotelIdAlreareadyUsedService;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.hotelapp.entity.Hotel;

public interface HotelServices {

	Hotel getHotelDetails();

	boolean addToDatabase(Hotel hotel) throws HotelIdAlreareadyUsedService;

	Room getRoomDetails();

	Hotel getHotelID();

	boolean addToDatabase(Hotel hotel1, Room room);

	List<Hotel> getHotelBasedCity() throws HotelCitynotfoundservice;

}
