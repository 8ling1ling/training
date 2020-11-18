package cn.sunline.tiny.demo.entity;
public class TbsExpend{//tbs_expend

	private Integer id;//id

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}
	private Integer uId;//u_id

	public void setUId(Integer uId){
		this.uId=uId;
	}

	public Integer getUId(){
		return this.uId;
	}
	private java.math.BigDecimal takeRecord;//take_record

	public void setTakeRecord(java.math.BigDecimal takeRecord){
		this.takeRecord=takeRecord;
	}

	public java.math.BigDecimal getTakeRecord(){
		return this.takeRecord;
	}
	private java.util.Date takeTime;//take_time

	public void setTakeTime(java.util.Date takeTime){
		this.takeTime=takeTime;
	}

	public java.util.Date getTakeTime(){
		return this.takeTime;
	}
	private java.util.Date time;//time

	public void setTime(java.util.Date time){
		this.time=time;
	}

	public java.util.Date getTime(){
		return this.time;
	}
}
