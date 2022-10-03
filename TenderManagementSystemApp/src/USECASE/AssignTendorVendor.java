package USECASE;

import java.util.Scanner;

import Bean.TenderStatusBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import DAO.VendorDao;
import DAO.VendorDaoImpl;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;

public class AssignTendorVendor {

	public static void main(String[] args) {
		
		
		  System.out.println("---- Welcome  ----");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter vendor Id");
			int vendorid=sc.nextInt();
			
			
			System.out.println("Enter Tender Id");
			int tenderid=sc.nextInt();
			
			
			
			System.out.println("Enter bid Id");
			int bidId=sc.nextInt();
			
			
			AdministratorDao dao=new AdministratorDaoImpl();
					
			try {
				
				
			 TenderStatusBean t=dao.assigntender(tenderid, vendorid, bidId);
			 
			 
			    System.out.println("BidderId    : "+t.getBidderId());
				System.out.println("TendorId    : " +t.getTendorId());
				System.out.println("VendorId    : " + t.getVendorId());
				System.out.println("Tendername  : "+t.getTendername());
				System.out.println("Vendorname  : "+t.getVendorname());
				System.out.println("Status      : "+t.getStatus());
				
				 System.out.println("=================================================");
					 
					 
					 
				
			} catch (Exception e) {
				// TODO: handle exception
			}		
		
	       
	
	
	
	
	     
		
		
		
		
		
		
	}
}
