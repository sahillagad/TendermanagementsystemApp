package DAO;

import java.util.List;

import Bean.TenderBean;
import Bean.TenderStatusBean;
import Bean.VendorBean;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;

public interface VendorDao {


	public VendorBean LoginVendor(String Username,String password)throws VendorException;
	public List<TenderBean> ViewAllTender() throws TenderException ;
	
	public String BidagainstTender(int vendorid,int tenderid,int bidAmount,String bidstatus) throws VendorException,TenderException;
	
	public TenderStatusBean  ViewstatusBid(int  bidid);
	
	public  List<TenderStatusBean> ViewhisownBid(int vendorId);
	
	
	
	
	
	
}
