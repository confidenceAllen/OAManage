package com.cn.loan.pojo;

public class Goods {
	
	private int goodsId;
	private String goodsName;
	private double price;
	private int total;
	private int sellNum;
	private int remianNum; //剩余货物
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSellNum() {
		return sellNum;
	}
	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}
	public int getRemianNum() {
		return remianNum;
	}
	public void setRemianNum(int remianNum) {
		this.remianNum = total-sellNum;
	}
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(int goodsId, String goodsName, double price, int total,
			int sellNum, int remianNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.total = total;
		this.sellNum = sellNum;
		this.remianNum = remianNum;
	}
	
}
