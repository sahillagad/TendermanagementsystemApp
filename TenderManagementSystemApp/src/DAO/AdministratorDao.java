package DAO;

import java.util.List;

import Bean.TenderBean;
import Bean.TenderStatusBean;
import Bean.VendorBean;
import USERDEFINEEXCEPTION.AdminstratorException;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;

public interface AdministratorDao {
	
	public boolean administratorLogin(String username,String password)throws AdminstratorException ;

	public String registerVendor(VendorBean vendor);
	
	
	public List<VendorBean> ViewAllVendor()throws VendorException;

	
	public boolean CreateNewtenders(TenderBean tender)throws TenderException;
	
	public List<TenderBean> ViewAllTender() throws TenderException ;
	
	public List<TenderStatusBean> ViewAlltheBidstender(int TenderId);
	
	public TenderStatusBean assigntender(int tenderid,int vendorid,int bidid)throws TenderException;
	
	
}
