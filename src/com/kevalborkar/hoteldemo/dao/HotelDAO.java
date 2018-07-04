package com.kevalborkar.hoteldemo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jspiders.singleton.SingletonFactory;
import com.kevalborkar.hoteldemo.dto.HotelDTO;

public class HotelDAO {

	public HotelDAO() {
		System.out.println("HotelDAO object created!");
	} 
	
	SessionFactory factory = SingletonFactory.getFactory();
	
	public void createHotel(HotelDTO dto) {
		
		System.out.println("createHotel Method started");
		//Component 1
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(HotelDTO.class);
		
		//Component2
		//SessionFactory factory = SingletonFactory.getFactory();
		
		//Component 3
		Session session = factory.openSession();
		Transaction tx  = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
		System.out.println("createHotel Method ended");
		
	}
	
	public List<HotelDTO> getHotelByAddr(String addr){
		
		System.out.println("getHotelByAddr Method started");
		
		String hql = "from HotelDTO where hotelAddr = '"+addr+"'";
		List<HotelDTO> hTList = null;
		Session session = factory.openSession();
		
		try {
			Query qry = session.createQuery(hql);
			
			hTList = qry.list();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		System.out.println("getHotelByAddr Method ended");

		return hTList;
	}
	public void getHotelByName(String hotelName) {
		
		System.out.println("getHotelByName Method started");
		
		Session session = factory.openSession();
		String hql = "from HotelDTO where hotelName='"+hotelName+"'";
		
		Query qry = session.createQuery(hql);
		HotelDTO htNameFromDb = (HotelDTO) qry.uniqueResult();
		
		System.out.println(htNameFromDb);
		
		System.out.println("getHotelByName Method ended");
	} 
	

	public void getAllHotels() {
		
		System.out.println("getAllHotels Method started");
		
		Session session = factory.openSession();
		String hql = "from HotelDTO";
		try {
			Query qry = session.createQuery(hql);
			List<HotelDTO> htNameFromDb = qry.list();
			for (HotelDTO hotels : htNameFromDb) {

				System.out.println(hotels);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println("getAllHotels Method ended");
	} 
	
	public void getRoomsAndPriceByName(String htName){
		
		Session session = factory.openSession();
		String hql = "Select H.roomName , H.roomPrice from HotelDTO H where "+
					 "hotelName='"+htName+"'";
		Object[] dtoFromDb = null;
		try {
			
			Query qry = session.createQuery(hql);
			dtoFromDb = (Object[]) qry.uniqueResult();
			
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		for (Object roomsAndPrice : dtoFromDb) {
			System.out.println(roomsAndPrice);
		}
		
	}
	
	public void getNameAndPriceByAddress(String address){
		Session session = factory.openSession();
		String hql = "Select H.hotelName , H.roomPrice from HotelDTO H where "+
					 "hotelAddr='"+address+"'";
		List<Object[]> htFromDb = null;
	
		try {
			Query qry = session.createQuery(hql);
			htFromDb = qry.list();
			for (Object[] NameAndPriceArr : htFromDb) {
				
				for (Object NameAndPrice : NameAndPriceArr) {
					System.out.println(NameAndPrice);
				}
				
				System.out.println("-----------");
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public int getTotalNoOfHotels() {
		Session session = factory.openSession();
		String hql = "Select count(*) from HotelDTO ";
		
		int noOfHotels=0;
		try {
			Query qry = session.createQuery(hql);
			noOfHotels = Integer.valueOf(String.valueOf(qry.uniqueResult()));
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return noOfHotels;
	}
	
	public int updatePriceByName(String htName,double r_price) {
		Session session = factory.openSession();
		String hql = "Update HotelDTO H SET H.roomPrice='"+r_price+"' where H.hotelName='"+htName+"'";
		int res = 0;
		try {
			Query qry = session.createQuery(hql);
			res = qry.executeUpdate();
			Transaction tx = session.beginTransaction();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;
	}
	
	public int removeByName(String hotelName) {
		Session session = factory.openSession();
		String hql = "Delete from HotelDTO H where H.hotelName='"+hotelName+"'";
		int res = 0;
		try {
			Query qry = session.createQuery(hql);
			res = qry.executeUpdate();
			//Transaction tx = session.beginTransaction();
			//tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	
}
