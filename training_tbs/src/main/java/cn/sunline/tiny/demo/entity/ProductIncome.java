package cn.sunline.tiny.demo.entity;
public class ProductIncome{//product_income

	private Integer id;//id

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}
	private Integer uid;//uid

	public void setUid(Integer uid){
		this.uid=uid;
	}

	public Integer getUid(){
		return this.uid;
	}
	private Integer productId;//product_id

	public void setProductId(Integer productId){
		this.productId=productId;
	}

	public Integer getProductId(){
		return this.productId;
	}
	private java.math.BigDecimal buyNum;//buy_num

	public void setBuyNum(java.math.BigDecimal buyNum){
		this.buyNum=buyNum;
	}

	public java.math.BigDecimal getBuyNum(){
		return this.buyNum;
	}
	private java.util.Date incomeDate;//income_date

	public void setIncomeDate(java.util.Date incomeDate){
		this.incomeDate=incomeDate;
	}

	public java.util.Date getIncomeDate(){
		return this.incomeDate;
	}
	private java.math.BigDecimal incomeMoney;//income_money

	public void setIncomeMoney(java.math.BigDecimal incomeMoney){
		this.incomeMoney=incomeMoney;
	}

	public java.math.BigDecimal getIncomeMoney(){
		return this.incomeMoney;
	}
	private java.util.Date time1;//time1

	public void setTime1(java.util.Date time){
		this.time1=time;
	}

	public java.util.Date getTime1(){
		return this.time1;
	}

	public String getState() {
		return  state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String state;//state
}
