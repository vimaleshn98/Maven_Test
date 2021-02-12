package com.mindtree.hotelapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.hotelapp.dao.HotelDao;
import com.mindtree.hotelapp.dao.impl.HotelDaoImplm;
import com.mindtree.hotelapp.entity.Hotel;
import com.mindtree.hotelapp.entity.Room;
import com.mindtree.hotelapp.exception.hotelexception;
import com.mindtree.hotelapp.exception.daoexception.HotelidAlreadyUsedDao;
import com.mindtree.hotelapp.exception.daoexception.hotelcitynotfounddao;
import com.mindtree.hotelapp.exception.serviceexception.HotelCitynotfoundservice;
import com.mindtree.hotelapp.exception.serviceexception.HotelIdAlreareadyUsedService;
import com.mindtree.hotelapp.service.HotelServices;

public class HotelServicesImplm implements HotelServices {

	private static HotelDao hoteldao = new HotelDaoImplm();
	
	@Override
	public Hotel getHotelDetails() {
		// TODO Auto-generated method stub
		return hoteldao.getHotelDetails();
	}

	@Override
	public boolean addToDatabase(Hotel hotel) throws HotelIdAlreareadyUsedService {
		// TODO Auto-generated method stub
		try {
			return hoteldao.addToDatabase(hotel);
		} catch (HotelidAlreadyUsedDao e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new HotelIdAlreareadyUsedService("Hotelid already used");
		}
	}

	@Override
	public Room getRoomDetails() {
		// TODO Auto-generated method stub
		return hoteldao.getRoomDetails();
	}

	@Override
	public Hotel getHotelID() {
		// TODO Auto-generated method stub
		return hoteldao.getHotelID();
	}

	@Override
	public boolean addToDatabase(Hotel hotel1, Room room) {
		// TODO Auto-generated method stub
		return hoteldao.addToDatabase(hotel1,room);
	}

	@Override
	public List<Hotel> getHotelBasedCity() throws HotelCitynotfoundservice {
		// TODO Auto-generated method stub
			try {
				return hoteldao.getHotelBasedCity();
			} catch (hotelcitynotfounddao e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new HotelCitynotfoundservice("City not found");
			}
		
	}

}
