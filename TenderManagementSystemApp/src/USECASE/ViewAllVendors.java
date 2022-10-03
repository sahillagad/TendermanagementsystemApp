package USECASE;

import java.util.List;
import java.util.function.Consumer;

import Bean.VendorBean;
import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import USERDEFINEEXCEPTION.VendorException;

public class ViewAllVendors {
	public static void main(String[] args) {
		
		
		AdministratorDao dao=new AdministratorDaoImpl();
		
		try {
			List<VendorBean> vList=dao.ViewAllVendor();
			
			
			
		Consumer<VendorBean> consumer=(VendorBean vb)->{
			System.out.println("Vendor Company : "+vb.getCompany());
			System.out.println("Vendor Id      : "+vb.getVendorId());
			System.out.println("Vendor Name    : "+vb.getName());
			System.out.println("Vendor Mobile  : "+vb.getMobile());
			System.out.println("Vendor Email   : "+vb.getEmail());
			System.out.println("Vendor Address : "+vb.getAddress());
			System.out.println("---------------------------******---------------------------");
			
		
		
		
		
		
		}; 
			
			
			
			vList.forEach(consumer);
			
			
			
			
			
			
			
			
			
		} catch (VendorException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
