package USECASE;

import java.util.Scanner;

import Bean.VendorBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;

public class RegisterNewVendor{



	
	
	
	
	public static void main(String[] args) {
	

	
        System.out.println("---- Welcome  ----");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter vendor Name");
		String name=sc.nextLine();
		
		
		System.out.println("Enter vendor Mobile Number");
		String mobile=sc.next();
		
		
		
		System.out.println("Enter vendor email Address");
		String email=sc.next();
		
		 
		
		System.out.println("Enter vendor Address");
	     String address=sc.next();  
		
	    
		
		System.out.println("Enter vendor Company Name");
		String companyName=sc.next();
		
	
		
		System.out.println("Enter vendor password");
		String password=sc.next();
		

		
		AdministratorDao administratorDao=new AdministratorDaoImpl();
		
		VendorBean vender=new VendorBean();
	     vender.setName(name);
	     vender.setMobile(mobile);
	     vender.setEmail(email);
	     vender.setAddress(address);
	     vender.setCompany(companyName);
	     vender.setPassword(password);
		
		 String s=administratorDao.registerVendor(vender);
		 System.out.println(s);
		 
		 
		
		
	}
}
