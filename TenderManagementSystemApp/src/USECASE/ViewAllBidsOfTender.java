package USECASE;

import java.util.List;
import java.util.Scanner;

import Bean.TenderStatusBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import DAO.VendorDao;
import DAO.VendorDaoImpl;

public class ViewAllBidsOfTender {

	
	public static void main(String[] args) {
		
		

		  System.out.println("---- Welcome  ----");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Tender id");
			int id=sc.nextInt();
			
			AdministratorDao aDao=new AdministratorDaoImpl();
			 
			List<TenderStatusBean> list=aDao.ViewAlltheBidstender(id);
			
		  
			for(TenderStatusBean t:list) {
			System.out.println("BidderId    : "+t.getBidderId());
			System.out.println("VendorId    : "+t.getVendorId());
			System.out.println("Vendor Name : "+t.getVendorname());
		    System.out.println("Bid Amount  : "+t.getAmount());
			
			
			 System.out.println("=================================================");
			}
	}
}
