package openapi;

public class XMLDeptDTO {
	private String code;
	private String name;
	private String loc;
	private String tel;
	public 	XMLDeptDTO(){
		
	}
	public XMLDeptDTO(String code, String name, String loc, String tel) {
		super();
		this.code = code;
		this.name = name;
		this.loc = loc;
		this.tel = tel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
