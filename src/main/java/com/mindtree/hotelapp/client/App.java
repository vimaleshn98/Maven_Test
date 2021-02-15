package com.mindtree.hotelapp.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mindtree.hotelapp.entity.Hotel;
import com.mindtree.hotelapp.entity.Room;
import com.mindtree.hotelapp.exception.serviceexception.HotelCitynotfoundservice;
import com.mindtree.hotelapp.exception.serviceexception.HotelIdAlreareadyUsedService;
import com.mindtree.hotelapp.service.HotelServices;
import com.mindtree.hotelapp.service.impl.HotelServicesImplm;

public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static HotelServices hotelservice = new HotelServicesImplm();

	// public static void main(String[] args) {
		int choice;
		boolean flag;
		do {
			System.out.println(
					"1 --> Create Hotel data\n 2 --> Create room Details\n 3--> display data\n\n Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("---------------  Create hotel data----------");
				System.out.println("---------------  Create hotel data----------");
				System.out.println("---------------  Create hotel data----------");
				Hotel hotel= hotelservice.getHotelDetails();
				try {
					flag = hotelservice.addToDatabase(hotel);
				} catch (HotelIdAlreareadyUsedService e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				break;
			case 2:
				System.out.println("----------- Create room Details -----------------");
				Hotel hotel1= hotelservice.getHotelID();
				Room room = hotelservice.getRoomDetails();
				flag = hotelservice.addToDatabase(hotel1,room);
				break;
			case 3:
				System.out.println("-----------display data-----------------");
				List<Hotel> hotel2;
				try {
					hotel2 = hotelservice.getHotelBasedCity();
					Iterator<Hotel> ci = hotel2.iterator();
					while (ci.hasNext()) {
						Hotel fi= ci.next();	
						System.out.println(fi);
					}
				} catch (HotelCitynotfoundservice e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}
				break;
			default:
				System.out.println("-----------------Existing Main Menu-------------------");
			}
		} while (choice <= 3 && choice >= 1);
	}

}
