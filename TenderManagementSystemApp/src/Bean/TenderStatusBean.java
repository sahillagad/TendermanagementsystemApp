package Bean;

public class TenderStatusBean {

	private int bidderId;
	private int tendorId;
	private int vendorId;
	private String tendername;
	private String vendorname;
    private String status;
    private int amount;
    
    
    
    

	public TenderStatusBean(int bidderId, int tendorId, int vendorId, String tendername, String vendorname,
			String status, int amount) {
		super();
		this.bidderId = bidderId;
		this.tendorId = tendorId;
		this.vendorId = vendorId;
		this.tendername = tendername;
		this.vendorname = vendorname;
		this.status = status;
		this.amount = amount;
	}
	public TenderStatusBean(int bidderId, int tendorId, int vendorId, String tendername, String vendorname,
			String status) {
		super();
		this.bidderId = bidderId;
		this.tendorId = tendorId;
		this.vendorId = vendorId;
		this.tendername = tendername;
		this.vendorname = vendorname;
		this.status = status;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getTendorId() {
		return tendorId;
	}
	public void setTendorId(int tendorId) {
		this.tendorId = tendorId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getTendername() {
		return tendername;
	}
	public void setTendername(String tendername) {
		this.tendername = tendername;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TenderStatusBean [bidderId=" + bidderId + ", tendorId=" + tendorId + ", vendorId=" + vendorId
				+ ", tendername=" + tendername + ", vendorname=" + vendorname + ", status=" + status + "]";
	}
    
    
    
	
	
	
	
	
}
