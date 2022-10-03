package Bean;

public class VendorBean {
	
  private int vendorId;
  private String name;
  private String mobile;
  private String email;
  private String address;
  private String company;
  private String password;
  
  
  
  
public VendorBean() {
	super();
}
public VendorBean(int vendorId, String name, String mobile, String email, String address, String company,
		String password) {
	super();
	this.vendorId = vendorId;
	this.name = name;
	this.mobile = mobile;
	this.email = email;
	this.address = address;
	this.company = company;
	this.password = password;
}
public int getVendorId() {
	return vendorId;
}
public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "VendorBean [vendorId=" + vendorId + ", name=" + name + ", mobile=" + mobile + ", email=" + email
			+ ", address=" + address + ", company=" + company + ", password=" + password + "]";
}
  
  
  
	
	
}
