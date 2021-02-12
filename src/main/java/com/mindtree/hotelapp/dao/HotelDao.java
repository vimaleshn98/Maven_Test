package com.mindtree.hotelapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.hotelapp.entity.Hotel;
import com.mindtree.hotelapp.entity.Room;
import com.mindtree.hotelapp.exception.hotelexception;
import com.mindtree.hotelapp.exception.daoexception.HotelidAlreadyUsedDao;
import com.mindtree.hotelapp.exception.daoexception.hotelcitynotfounddao;

public interface HotelDao {

	Hotel getHotelDetails();

	boolean addToDatabase(Hotel hotel) throws HotelidAlreadyUsedDao;

	Room getRoomDetails();

	Hotel getHotelID();

	boolean addToDatabase(Hotel hotel1, Room room);

	List<Hotel> getHotelBasedCity() throws hotelcitynotfounddao;

}
