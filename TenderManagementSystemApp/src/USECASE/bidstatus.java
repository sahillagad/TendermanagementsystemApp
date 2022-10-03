package USECASE;

import java.util.Scanner;

import Bean.TenderStatusBean;
import DAO.VendorDao;
import DAO.VendorDaoImpl;

public class bidstatus {

	public static void main(String[] args) {
		        System.out.println("---- Welcome  ----");
			
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Bid id");
				int id=sc.nextInt();
				VendorDao dao=new VendorDaoImpl();
				
				TenderStatusBean t=dao.ViewstatusBid(id);
				System.out.println("BidderId    : "+t.getBidderId());
				System.out.println("TendorId    : " +t.getTendorId());
				System.out.println("VendorId    : " + t.getVendorId());
				System.out.println("Tendername  : "+t.getTendername());
				System.out.println("Vendorname  : "+t.getVendorname());
				System.out.println("Status      : "+t.getStatus());
				
				 System.out.println("=================================================");
				
				
			
	}
}
