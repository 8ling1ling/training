package cn.sunline.tiny.demo.entity;

public class Other {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String id;
    private String productName;
    private String buyNum;
    private String State;
    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
