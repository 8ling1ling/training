package cn.sunline.tiny.demo.entity;
public class StoredRecord{//stored_record

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
	private java.math.BigDecimal storeMoney;//store_money

	public void setStoreMoney(java.math.BigDecimal storeMoney){
		this.storeMoney=storeMoney;
	}

	public java.math.BigDecimal getStoreMoney(){
		return this.storeMoney;
	}
	private java.util.Date storeTime;//store_time

	public void setStoreTime(java.util.Date storeTime){
		this.storeTime=storeTime;
	}

	public java.util.Date getStoreTime(){
		return this.storeTime;
	}
	private java.util.Date time;//time

	public void setTime(java.util.Date time){
		this.time=time;
	}

	public java.util.Date getTime(){
		return this.time;
	}
}
