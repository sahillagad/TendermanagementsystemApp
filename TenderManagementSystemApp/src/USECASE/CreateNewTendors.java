package USECASE;

import java.util.Scanner;

import Bean.TenderBean;
import Bean.VendorBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import USERDEFINEEXCEPTION.TenderException;

public class CreateNewTendors {

	public static void main(String[] args) {
		

	   System.out.println("---- Welcome  ----");
		
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Tender Name");
			String name=sc.nextLine();
			
			
			System.out.println("Enter Tender of Type ");
			String type=sc.nextLine();
			
			
			
			System.out.println("Enter Tender Price");
			int price=sc.nextInt();
			
 
			
			System.out.println("Enter Tender Location");
			String location=sc.next();
			
			System.out.println("Enter Tender Detail (description)");
		     String description=sc.next();  
			
		   
			
		
			
		

			
			AdministratorDao administratorDao=new AdministratorDaoImpl();
			
			TenderBean tender=new TenderBean();
			tender.setName(name);
			tender.setPrice(price);
			tender.setType(type);
			tender.setDescription(description);
			tender.setLocation(location);
			
			
			
			
			
			try {
				administratorDao.CreateNewtenders(tender);
			} catch (TenderException e) {
		
				e.printStackTrace();
			}
			 
			 
	
	
	
}
}
