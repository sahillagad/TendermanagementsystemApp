package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.TenderBean;
import Bean.TenderStatusBean;
import Bean.VendorBean;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;
import utility.DBUtility;

public class VendorDaoImpl implements VendorDao {

	@Override
	public VendorBean LoginVendor(String Username, String password) throws VendorException {
		
		
		VendorBean vendor=null;
		
		try(Connection conn=DBUtility.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement
					("select * from  vendor where  email=? AND password=? ");
			
			ps.setString(1,Username);
			ps.setString(2, password);

			ResultSet resultSet=ps.executeQuery();
			
			if(resultSet.next()) {
				
				 int vendorid=resultSet.getInt("vendorid");
	    		 String vendorName=resultSet.getString("vendorName");           
	    		 String mobile=resultSet.getString("mobile");                
	    		 String email=resultSet.getString("email");        
	    		 String address=resultSet.getString("address");                
	    		 String company=resultSet.getString("company");                
	    		 String password1 =resultSet.getString("password");
	    		 
	    		 vendor=new VendorBean(vendorid,vendorName,mobile,email,address,company,password1);
	     		
	           
				
				
				
			}
			else {
			
				
				throw new VendorException("invalid userID and passward");
				
			}
			
			
		}
		catch (SQLException e) {
			// TODO: handle exception
		  throw new VendorException(e.getMessage());
		}
		
		
		
		
		return vendor;
	}
	
	@Override
	public List<TenderBean> ViewAllTender() throws TenderException {
	
    List<TenderBean> tenderlist=new ArrayList<>();
    
    
    
    try(Connection conn=DBUtility.provideConnection()) {
    	
    	
    	PreparedStatement ps=conn.prepareStatement("select * from tender");
    	
    	ResultSet  resultSet=ps.executeQuery();
    	
    	while(resultSet.next()) {
    		
    		 int tenderid=resultSet.getInt("tenderid");
    		 String name=resultSet.getString("name");           
    		 String type=resultSet.getString("type");                
    		 int price=resultSet.getInt("price");        
    		 String description=resultSet.getString("description");                
    		 String location=resultSet.getString("location");                
    		
    		 
    		 
    	 TenderBean tender=new TenderBean(tenderid,name,type,price,description,location);
    		
    		tenderlist.add(tender);
    	}
    	 	
		
	} catch (SQLException e) {
		TenderException ve=new TenderException(e.getMessage());    	
        throw ve;
	}
    if(tenderlist.size()==0) {
    	
    	TenderException ve=new TenderException("");    	
        throw ve;
     
    }
    
    
		
		
	
    
	return tenderlist;	
	}

	
	

	
	@Override
	public String BidagainstTender(int vendorid, int tenderid, int bidAmount, String bidstatus)
			throws VendorException, TenderException {
	
 
		String message="Tender Bidding Failed!";
		
		try (Connection conn=DBUtility.provideConnection()){
			
			
			PreparedStatement ps=conn.prepareStatement("select * from vendor where vendorid=?");
			ps.setInt(1,vendorid);
		    ResultSet rs=ps.executeQuery();
			
		    if(rs.next()) {
		    	
		    	
		    	
		    	
				PreparedStatement ps1=conn.prepareStatement("select * from tender where tenderid=?");
			     ps1.setInt(1,tenderid);
				ResultSet rs1=ps1.executeQuery();
			    
			    if(rs1.next()) {
			    	

					PreparedStatement ps2=conn.prepareStatement("insert into bidder(vendorid,tenderid,bidAmount,bidstatus) values(?,?,?,?)");
				    ps2.setInt(1,vendorid);
				    ps2.setInt(2, tenderid);
				    ps2.setInt(3, bidAmount);
				    ps2.setString(4,bidstatus);
				    
					
					
				int x=ps2.executeUpdate();
			     	
				if(x>0) {
					message="You have successfully Bid for the Tender";
				}
				else {
					
					throw new VendorException("Technical error.....");
					
				}
				
				
			    }
			    else {
			    	
			    	throw new TenderException("Invalid Tender Id....");
			    }
		    }
		    else {
		    	
		    	
		    	throw new VendorException("Invalid Vendor Id....");
		    }
			
		} catch (SQLException e) {
			
			throw new VendorException(e.getMessage());
		}
		
		
		
		
		
		
		
		return message;
	}

	
	
	
	
	
	
	@Override
	public TenderStatusBean ViewstatusBid(int bidid) {
		TenderStatusBean statusBean=null;
		
		try(Connection conn=DBUtility.provideConnection()) {
			
			
			PreparedStatement ps=conn.prepareStatement(" select b.bidid,t.tenderid,v.vendorid,t.name,v.vendorName,b.bidstatus from vendor v INNER JOIN tender t INNER JOIN bidder b ON v.vendorid=b.vendorid AND t.tenderid=b.tenderid AND  b.bidid=?");
			ps.setInt(1,bidid);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
				 int bidid1=rs.getInt("bidid"); 
				 int tenderid=rs.getInt("tenderid");
				 int vendorid=rs.getInt("vendorid");
				 String name=rs.getString("name");
				 String vendorName=rs.getString("vendorName");
				 String bidstatus=rs.getString("bidstatus");
				
				 statusBean=new TenderStatusBean(bidid1,tenderid, vendorid, name, vendorName, bidstatus);
				 
				 
				 
			}
			else {
				
				System.out.println("invalid bid id");
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return statusBean;
	}

	
	
	
	
	
	
	
	@Override
	public List<TenderStatusBean> ViewhisownBid(int vendorId) {
		
		List<TenderStatusBean> tenderliList=new ArrayList<>();
  
		
		try(Connection conn=DBUtility.provideConnection()) {
			
			
			PreparedStatement ps=conn.prepareStatement(" select b.bidid,t.tenderid,v.vendorid,t.name,v.vendorName,b.bidstatus from vendor v INNER JOIN tender t INNER JOIN bidder b ON v.vendorid=b.vendorid AND t.tenderid=b.tenderid AND  v.vendorid=?");
			ps.setInt(1,vendorId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				 int bidid1=rs.getInt("bidid"); 
				 int tenderid=rs.getInt("tenderid");
				 int vendorid=rs.getInt("vendorid");
				 String name=rs.getString("name");
				 String vendorName=rs.getString("vendorName");
				 String bidstatus=rs.getString("bidstatus");
				
				TenderStatusBean statusBean=new TenderStatusBean(bidid1,tenderid, vendorid, name, vendorName, bidstatus);
				 
				 tenderliList.add(statusBean);
				 
			}
         
			
			
			
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		  if(tenderliList.size()==0) {
				
				System.out.println("invalid vendor id");
			}
			
		
		
		
		
		
		
		
		
		
		
		return tenderliList;
		
		

	}

	
	
	
	
}






























