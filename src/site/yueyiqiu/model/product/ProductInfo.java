package site.yueyiqiu.model.product;

import java.io.Serializable;
import java.util.Date;

import site.yueyiqiu.model.Sex;

public class ProductInfo implements Serializable{
	
	private int id;
	private String name;
	private String description;
	private Date createTime=new Date();
	private double basePrice;
	private double marketPrice;
	private double salePrice;
	private boolean commend=false;
	private Sex sexrequest;
	private int clickCount=1;
	private int sellCount=0;
	private ProductCategory category;
	private UploadFile uploadfile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public boolean isCommend() {
		return commend;
	}
	public void setCommend(boolean commend) {
		this.commend = commend;
	}
	public Sex getSexrequest() {
		return sexrequest;
	}
	public void setSexrequest(Sex sexrequest) {
		this.sexrequest = sexrequest;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public UploadFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	
	
	
}
