package USECASE;

import java.util.Scanner;

import DAO.VendorDao;
import DAO.VendorDaoImpl;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;

public class bidTender {

	public static void main(String[] args) {
		
		   System.out.println("---- Welcome  ----");
			
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter vendor Id");
				int vendorid=sc.nextInt();
				
				
				System.out.println("Enter Tender Id");
				int tenderid=sc.nextInt();
				
				
				
				System.out.println("Enter bid Amount");
				int bidAmount=sc.nextInt();
				
				
			
		        String bidstatus="No";
		
		
		
		
		         VendorDao dao=new VendorDaoImpl();
		         try {
					
		        	 String result=dao.BidagainstTender(vendorid, tenderid, bidAmount, bidstatus);
				      System.out.println(result);
		         } catch (VendorException | TenderException e) {
					
					e.printStackTrace();
				}

		
	}
}
