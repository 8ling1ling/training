package cn.sunline.tiny.demo.entity;
public class TbsAccount{//tbs_account

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
	private java.math.BigDecimal accountBalance;//account_balance

	public void setAccountBalance(java.math.BigDecimal accountBalance){
		this.accountBalance=accountBalance;
	}

	public java.math.BigDecimal getAccountBalance(){
		return this.accountBalance;
	}
	private java.util.Date time;//time

	public void setTime(java.util.Date time){
		this.time=time;
	}

	public java.util.Date getTime(){
		return this.time;
	}
}
