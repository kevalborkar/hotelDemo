package com.kevalborkar.hoteldemo.util;

import java.util.List;

import com.kevalborkar.hoteldemo.dao.HotelDAO;
import com.kevalborkar.hoteldemo.dto.HotelDTO;

public class HotelTester {

	public static void main(String[] args) {
		
		System.out.println("Main Method started");
		
		//HotelDTO hotelRef = new HotelDTO();
		//hotelref.setId(id);
		//hotelRef.setHotelName("The Golden Oak");
		//hotelRef.setRoomName("King");
		//hotelRef.setRoomPrice(3000);
		//hotelRef.setHotelAddr("Majestic");
		
		HotelDAO dao = new HotelDAO();
		//dao.createHotel(hotelRef);
		
		//List<HotelDTO> htFromDb = dao.getHotelByAddr("MAJESTIC");
		/*
		if(htFromDb != null) {
			for (HotelDTO hotels : htFromDb) {
				System.out.println(hotels);
			}
		}else {
			System.out.println("We are not available at that particular location");
		}*/
		
		//dao.getHotelByName("The People Tree");
		
		
		//dao.getAllHotels();
		
		//dao.getRoomsAndPriceByName("Radisson");
		
		dao.getNameAndPriceByAddress("Majestic");
		
		//int hotels = dao.getTotalNoOfHotels();
		//System.out.println(hotels);
		
		/*int res = dao.updatePriceByName("Ashoka" , 3500);
			if(res==1) {
				System.out.println("Updated successfully");
			}
			else {
				System.out.println("Something Went Wrong!");
			}
		*/
		
		/*int res = dao.removeByName("Hotel To be Deleted");
		if(res==1) {
			System.out.println("Hotel deleted successfully");
		}
		else {
			System.out.println("Something Went Wrong!");
		}
		*/
		System.out.println("Main Method ended");
	}
	

}
