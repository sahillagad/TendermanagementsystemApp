package USECASE;

import java.util.List;
import java.util.Scanner;

import Bean.TenderStatusBean;
import DAO.VendorDao;
import DAO.VendorDaoImpl;

public class showhistory {

	public static void main(String[] args) {
		
		
		  System.out.println("---- Welcome  ----");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Vendor id");
			int id=sc.nextInt();
			VendorDao dao=new VendorDaoImpl();
			
			List<TenderStatusBean> list=dao.ViewhisownBid(id);
			
			for(TenderStatusBean t:list) {
			System.out.println("BidderId    : "+t.getBidderId());
			System.out.println("TendorId    : " +t.getTendorId());
			System.out.println("Tendername  : "+t.getTendername());
			System.out.println("Status      : "+t.getStatus());
			
			 System.out.println("=================================================");
			}
	}
}
