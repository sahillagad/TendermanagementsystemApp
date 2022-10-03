package USECASE;

import java.util.Scanner;
import java.util.function.Consumer;

import Bean.VendorBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import DAO.VendorDao;
import DAO.VendorDaoImpl;
import USERDEFINEEXCEPTION.AdminstratorException;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;

public class VendorLogin {

	
	public static void main(String[] args) {
		
		
		
	System.out.println("---- Welcome  ----");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username=sc.next();
		
		
		System.out.println("Enter Password");
		String password=sc.next();
		
		
		VendorDao  dao=new VendorDaoImpl();
		try {
		
		VendorBean	 vb= dao.LoginVendor(username, password);
	
		
		
			System.out.println("Vendor Company : "+vb.getCompany());
			System.out.println("Vendor Id      : "+vb.getVendorId());
			System.out.println("Vendor Name    : "+vb.getName());
			System.out.println("Vendor Mobile  : "+vb.getMobile());
			System.out.println("Vendor Email   : "+vb.getEmail());
			System.out.println("Vendor Address : "+vb.getAddress());
			System.out.println("---------------------------******---------------------------");
			
		
		
		
		} catch (VendorException e) {
		
			e.printStackTrace();
		}
		 
		
		System.out.println("---- Thank You ----");
		
	
		
		
		
		
		
		
		
	}
}
