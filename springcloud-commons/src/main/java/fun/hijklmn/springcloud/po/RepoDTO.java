package fun.hijklmn.springcloud.po;

public class RepoDTO {

	private String orderId;
	
	private String goodsName;
	
	private Integer number;
	
	private String comment;
	
	private String address;

	public RepoDTO() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RepoDTO [orderId=" + orderId + ", goodsName=" + goodsName + ", number=" + number + ", comment="
				+ comment + ", address=" + address + "]";
	}
	
}
