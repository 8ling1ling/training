package cn.sunline.tiny.demo.entity;
public class TbsVersion{//tbs_version

	private Integer id;//id

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}
	private String version;//version

	public void setVersion(String version){
		this.version=version;
	}

	public String getVersion(){
		return this.version;
	}
	private Integer type;//type

	public void setType(Integer type){
		this.type=type;
	}

	public Integer getType(){
		return this.type;
	}
}
