package Bean;

public class TenderBean {
	
	private int tenderId;
	private String name;
	private String type;
	private int price;
	private String description;
	private String location;
	
	
	
	
	public TenderBean(int tenderId, String name, String type, int price, String description, String location) {
		super();
		this.tenderId = tenderId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
		this.location = location;
	}
	
	



	public TenderBean() {
		
	}





	public int getTenderId() {
		return tenderId;
	}
	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "TenderBean [tenderId=" + tenderId + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", description=" + description + ", location=" + location + "]";
	}
	
	
	
	

}
