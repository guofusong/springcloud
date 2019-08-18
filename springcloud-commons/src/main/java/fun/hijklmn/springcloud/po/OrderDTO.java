package fun.hijklmn.springcloud.po;

import java.util.Date;

public class OrderDTO {
	
	private String orderId;
	
	private String goodsName;
	
	private Date createDate;
	
	private Long amount;
	
	private Integer number; 
	
	private String nonStr;
	
	private Integer payType;

	public OrderDTO() {
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNonStr() {
		return nonStr;
	}

	public void setNonStr(String nonStr) {
		this.nonStr = nonStr;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", goodsName=" + goodsName + ", createDate=" + createDate + ", amount="
				+ amount + ", number=" + number + ", nonStr=" + nonStr + ", payType=" + payType + "]";
	}
	
}
