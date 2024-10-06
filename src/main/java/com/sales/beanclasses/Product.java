package com.sales.beanclasses;

public class Product {

    private int pid;
    private String productName;
    private float price;
   

    public int getPid() {
        return this.pid;
    }

    public String getProductName() {
        return this.productName;
    }

    public float getPrice() {
        return this.price;
    }


    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
