package fun.hijklmn.springcloud.biz;

public class Rsp {

	private Integer code;
	
	private String result;
	
	public Rsp() {}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Rsp [code=" + code + ", result=" + result + "]";
	}
	
}
