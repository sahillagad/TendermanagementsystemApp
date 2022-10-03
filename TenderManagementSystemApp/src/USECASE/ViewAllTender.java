package USECASE;

import java.util.List;
import java.util.function.Consumer;

import Bean.TenderBean;
import Bean.VendorBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import USERDEFINEEXCEPTION.VendorException;

public class ViewAllTender {
	
	public static void main(String[] args) {
		
	
	AdministratorDao dao=new AdministratorDaoImpl();
	
	try {
		List<TenderBean> tList=dao.ViewAllTender();
		
		
		
	Consumer<TenderBean> consumer=(TenderBean t) ->{
		
		System.out.println("Tender Name    : " +t.getName());
		System.out.println("Tender ID      : " + t.getTenderId());
		System.out.println("Location       : "+t.getLocation());
		System.out.println("Type of Tender : "+t.getType());
		System.out.println("Tender Price   : "+t.getPrice());
		System.out.println("Tender Detail  : "+t.getDescription());
	
		
		 System.out.println("=================================================");
		
		
	};
		
		
	tList.forEach(consumer);
		
		
		
		
		
		
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	}

}
