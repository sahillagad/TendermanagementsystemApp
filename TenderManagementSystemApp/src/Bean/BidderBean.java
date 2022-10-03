package Bean;

public class BidderBean {

	private int bidId;
	private int vendorId;
	private int tendorId;
	private int bidAmount;
	private String bidStatus;
	
	
	
	
	
	
	public BidderBean(int bidId, int vendorId, int tendorId, int bidAmount, String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tendorId = tendorId;
		this.bidAmount = bidAmount;
		this.bidStatus = bidStatus;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getTendorId() {
		return tendorId;
	}
	public void setTendorId(int tendorId) {
		this.tendorId = tendorId;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	@Override
	public String toString() {
		return "BidderBean [bidId=" + bidId + ", vendorId=" + vendorId + ", tendorId=" + tendorId + ", bidAmount="
				+ bidAmount + ", bidStatus=" + bidStatus + "]";
	}
	
	
	
	
	
	
	
	
}
