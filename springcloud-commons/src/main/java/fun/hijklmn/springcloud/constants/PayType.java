package fun.hijklmn.springcloud.constants;

public enum PayType {

	WXPAY(1, "wxpay"),ALIPAY(2, "alipay");
	
	private Integer code;
	
	private String payType;
	
	private PayType(Integer code, String payType) {
		this.code = code;
		this.payType = payType;
	}
	
	public Integer code() {
		return this.code;
	}
	
	public String payType() {
		return this.payType;
	}
	
}
