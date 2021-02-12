package com.mindtree.hotelapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.hotelapp.dao.HotelDao;
import com.mindtree.hotelapp.entity.Hotel;
import com.mindtree.hotelapp.entity.Room;
import com.mindtree.hotelapp.exception.hotelexception;
import com.mindtree.hotelapp.exception.daoexception.HotelidAlreadyUsedDao;
import com.mindtree.hotelapp.exception.daoexception.hotelcitynotfounddao;
import com.mindtree.hotelapp.utility.DataBase;

public class HotelDaoImplm  implements HotelDao{
	private static Scanner scanner = new Scanner(System.in);
	private static Connection con=null;
	private static PreparedStatement preparedStatement =null;
	private static Statement st =null;
	private static ResultSet rs =null;
	private static Statement st2 =null;
	private static ResultSet rs2 =null;
	@Override
	public Hotel getHotelDetails() {
		System.out.println("Enter the Id of hotel ");
		short id = scanner.nextShort();
		System.out.println("enter the name of Hotel");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the city where hotel resides");
		String city = scanner.nextLine();
		Hotel hotel = new Hotel(id,name,city);
		return hotel;
	}


	@Override
	public boolean addToDatabase(Hotel hotel) throws HotelidAlreadyUsedDao {
		// TODO Auto-generated method stub
		int j=0;
		try {
			con = DataBase.getConnection();
			String sql2 = "insert into Hotel values(?,?,?)";
			preparedStatement = con.prepareStatement(sql2);
			preparedStatement.setShort(1, hotel.getHotelId());
			preparedStatement.setString(2, hotel.getHotelName());
			preparedStatement.setString(3, hotel.getCity());
			j = preparedStatement.executeUpdate();
			if(j>0) {
				return true;
			}else
				return false;
		}catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new HotelidAlreadyUsedDao("This id already used");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Room getRoomDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Id of room");
		short id = scanner.nextShort();
		System.out.println("enter the roomtype ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the cost");
		float cost = scanner.nextFloat();
		Room room = new Room(id,name,cost);
		return room;
	}


	@Override
	public Hotel getHotelID() {
		
		// TODO Auto-generated method stub
		System.out.println("Enter  the id of Hotel");
		short id = scanner.nextShort();
		
		try {
			con = DataBase.getConnection();
			st =con.createStatement();
			rs = st.executeQuery("select * from Hotel where hotelid = "+id+"");
			rs.next();
			Hotel hotel = new Hotel(rs.getShort("hotelid"),rs.getString("name"),rs.getString("city"));
			return hotel;
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		
		finally {
			DataBase.closeConnection(con);
			DataBase.closeStatement(st);
		}
		return null;
	}


	@Override
	public boolean addToDatabase(Hotel hotel1, Room room) {
		// TODO Auto-generated method stub
		int j=0;
		try {
			con = DataBase.getConnection();
			String sql2 = "insert into room values(?,?,?,?)";
			preparedStatement = con.prepareStatement(sql2);
			preparedStatement.setShort(1, room.getRoomId());
			preparedStatement.setString(2, room.getRoomType());
			preparedStatement.setFloat(3, room.getPrice());
			preparedStatement.setShort(4, hotel1.getHotelId());
			j = preparedStatement.executeUpdate();
			if(j>0) {
				return true;
			}else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Hotel> getHotelBasedCity() throws hotelcitynotfounddao {
		// TODO Auto-generated method stub
		List<Hotel> ls =new ArrayList<Hotel>();
		Statement st2 =null;
		ResultSet rs2 =null;
		String city = getcity();
		try {
			con = DataBase.getConnection();
			st2 =con.createStatement();
//			boolean flag = false;
			rs2 = st2.executeQuery("select * from Hotel inner join room  on Hotel.hotelid=room.hotelid where city = '"+city+"' order by Hotel.hotelid");
			while(rs2.next()) {
//				flag=true;
				Hotel hotel = new Hotel(rs2.getShort("hotelid"),rs2.getString("name"),rs2.getString("city"),new Room(rs2.getShort("roomid"),rs2.getString("roomtype"),rs2.getFloat("price")));
			    ls.add(hotel);
			}
//			if(!flag) {
//				throw new hotelcitynotfounddao("city not found");
//			}
			return ls;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return ls;
	}


	private String getcity() throws hotelcitynotfounddao {
		// TODO Auto-generated method stub
		System.out.println("enter the city name");
		String city = scanner.next();
		try {
			con = DataBase.getConnection();
			st =con.createStatement();
			rs = st.executeQuery("select * from Hotel where city = '"+city+"'");
			if(rs.next()==false) {
				throw new hotelcitynotfounddao("city not found");
			}else {
			System.out.println(rs.getInt(1));
			return city;
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new hotelcitynotfounddao("city not found");
		}
		
		finally {
			DataBase.closeConnection(con);
			DataBase.closeStatement(st);
		}
		return city;
		
	}


	

}
