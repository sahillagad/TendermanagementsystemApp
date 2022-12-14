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
import USERDEFINEEXCEPTION.AdminstratorException;
import USERDEFINEEXCEPTION.TenderException;
import USERDEFINEEXCEPTION.VendorException;
import utility.DBUtility;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public boolean administratorLogin(String username, String password) throws AdminstratorException {
		
		boolean result=false;
		try(Connection conn=DBUtility.provideConnection()){
		
			PreparedStatement ps= conn.prepareStatement("select * from admin where username=? AND password=?");	
			
			ps.setString(1,username);
			ps.setString(2, password);
	
			ResultSet resultSet=ps.executeQuery();
			
			if(resultSet.next()) {
				
			 System.out.println("login successfully.....");
			 result=true;
				
			}
			else {
				
				  AdminstratorException ae1=new AdminstratorException("Invalid UserName and Passward");
				  throw ae1;
			}
			
		}
		catch (SQLException e) {
			
			  AdminstratorException ae=new AdminstratorException(e.getMessage());
			  throw ae;
		}
		
		
		
		return result;
	}

	@Override
	public String registerVendor(VendorBean vendor) {
		
		String message="Not Inserted";
		
		try(Connection conn=DBUtility.provideConnection()){
		PreparedStatement ps=conn.prepareStatement
				("insert into vendor(vendorName,mobile,email,address,company,password) values(?,?,?,?,?,?)");
		
		ps.setString(1,vendor.getName());
		ps.setString(2,vendor.getMobile());
		ps.setString(3,vendor.getEmail());
		ps.setString(4,vendor.getAddress());
		ps.setString(5,vendor.getCompany());
		ps.setString(6,vendor.getPassword());
		
	
		int x=ps.executeUpdate();
		
		if(x>0) {
		 message="...Student Registered Successfully...";	
		}
		
		} catch (SQLException e) {
			message=e.getMessage();
		}
		
		
		
		return message;
		
	}

	
	
	
	
	@Override
	public List<VendorBean> ViewAllVendor() throws VendorException {
	
    List<VendorBean> venderlist=new ArrayList<>();
    
    
    
    try(Connection conn=DBUtility.provideConnection()) {
    	
    	
    	PreparedStatement ps=conn.prepareStatement("select * from vendor");
    	
    	ResultSet  resultSet=ps.executeQuery();
    	
    	while(resultSet.next()) {
    		
    		 int vendorid=resultSet.getInt("vendorid");
    		 String vendorName=resultSet.getString("vendorName");           
    		 String mobile=resultSet.getString("mobile");                
    		 String email=resultSet.getString("email");        
    		 String address=resultSet.getString("address");                
    		 String company=resultSet.getString("company");                
    		 String password =resultSet.getString("password");
    		 
    		 
    		VendorBean vendor=new VendorBean(vendorid,vendorName,mobile,email,address,company,password);
    		
            venderlist.add(vendor);
    	}
    	 	
		
	} catch (SQLException e) {
		VendorException ve=new VendorException(e.getMessage());    	
        throw ve;
	}
    if(venderlist.size()==0) {
    	
    	VendorException ve=new VendorException("");    	
        throw ve;
     
    }
    
    
		
		
	
    
	return venderlist;	
	}

	@Override
	public boolean CreateNewtenders(TenderBean tender) throws TenderException {
		
		boolean result=false;
		
		
		
		try(Connection conn=DBUtility.provideConnection()) {
			 
		PreparedStatement ps=conn.prepareStatement("insert into  tender(name,type,price,description,location) values(?,?,?,?,?)");
			
		ps.setString(1,tender.getName());
		ps.setString(2,tender.getType());
		ps.setInt(3,tender.getPrice());	
		ps.setString(4,tender.getDescription());
		ps.setString(5,tender.getLocation());

		int x=ps.executeUpdate();
					
		if(x>0) {
			System.out.println("Tender Inserted.....");
		}
	
		}
		catch (Exception e) {
		 TenderException te=new TenderException(e.getMessage());
		
		  throw te;
		
		
		}
		
		
		
		
		
		
		
		
		
		
		return result;
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
	public List<TenderStatusBean> ViewAlltheBidstender(int TenderId) {
    List<TenderStatusBean> tenderliList=new ArrayList<>();
  
		
		try(Connection conn=DBUtility.provideConnection()) {
			
			
			PreparedStatement ps=conn.prepareStatement(" select b.bidid,b.bidAmount,t.tenderid,v.vendorid,t.name,v.vendorName,b.bidstatus from vendor v INNER JOIN tender t INNER JOIN bidder b ON v.vendorid=b.vendorid AND t.tenderid=b.tenderid AND  t.tenderid=?");
			ps.setInt(1,TenderId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				 int bidid1=rs.getInt("bidid"); 
				 int tenderid=rs.getInt("tenderid");
				 int vendorid=rs.getInt("vendorid");
				 int amount=rs.getInt("bidAmount");
				 String name=rs.getString("name");
				 
				 String vendorName=rs.getString("vendorName");
				 String bidstatus=rs.getString("bidstatus");
				
				TenderStatusBean statusBean=new TenderStatusBean(bidid1,tenderid, vendorid, name, vendorName, bidstatus,amount);
				 
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

	@Override
	public TenderStatusBean assigntender(int tenderid, int vendorid, int bidid) throws TenderException {
	
		
		
		
		TenderStatusBean statusBean=null;
		
		try(Connection conn=DBUtility.provideConnection()) {
			PreparedStatement ps1=conn.prepareStatement("update bidder set bidstatus='Yes' where  tenderid=? AND vendorid=? AND bidid=? AND bidstatus='No';");
			ps1.setInt(1,tenderid);
			ps1.setInt(2,vendorid);
			ps1.setInt(3,bidid);
			int rs1=ps1.executeUpdate();
			
			if(rs1>0) {
				
				PreparedStatement ps=conn.prepareStatement("select b.bidid,t.tenderid,v.vendorid,t.name,v.vendorName,b.bidstatus from vendor v INNER JOIN tender t INNER JOIN bidder b ON v.vendorid=b.vendorid AND t.tenderid=b.tenderid AND t.tenderid=? AND v.vendorid=? AND b.bidid=?");
				ps.setInt(1,tenderid);
				ps.setInt(2,vendorid);
				ps.setInt(3,bidid);
				ResultSet rs=ps.executeQuery();
	         
				
				if(rs.next()){
				
				int bidid1=rs.getInt("bidid"); 
				 int tenderid1=rs.getInt("tenderid");
				 int vendorid1=rs.getInt("vendorid");
				 String name=rs.getString("name");
				 String vendorName=rs.getString("vendorName");
				 String bidstatus=rs.getString("bidstatus");
				
				 statusBean=new TenderStatusBean(bidid1,tenderid, vendorid, name, vendorName, bidstatus);
				}
				else {
					
					throw new TenderException("Technical Error...");
				}
				
				
			}
			else {
				
				throw new TenderException("please enter a valid value");
			}
			}catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return statusBean;
	}
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
