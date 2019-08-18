package fun.hijklmn.springcloud.constants;

public enum BizCode {

	success(1, "success") , fail(0, "fail") ;
	
	private Integer code;
	
	private String message;
	
	private BizCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Integer code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
	
}
