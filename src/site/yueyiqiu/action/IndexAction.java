package site.yueyiqiu.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import site.yueyiqiu.model.product.ProductCategory;
import site.yueyiqiu.model.product.ProductInfo;

@Scope("prototype")
@Controller("indexAction")
public class IndexAction extends BaseAction{
	
	public String execute(){
		
		String where="where parent is null";
		this.categories=this.categoryDao.find(where, null, null, -1, -1).getList();
		this.product_clickcount=this.productDao.findClickCount();
		this.product_commend=this.productDao.findCommend();
		this.product_sellcount=this.productDao.findSellCount();
		
		return this.SUCCESS;
	}
	
	
	
	private List<ProductCategory> categories;
	private List<ProductInfo> product_commend;
	private List<ProductInfo> product_sellcount;
	private List<ProductInfo> product_clickcount;
	
	public List<ProductCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
	public List<ProductInfo> getProduct_commend() {
		return product_commend;
	}
	public void setProduct_commend(List<ProductInfo> product_commend) {
		this.product_commend = product_commend;
	}
	public List<ProductInfo> getProduct_sellcount() {
		return product_sellcount;
	}
	public void setProduct_sellcount(List<ProductInfo> product_sellcount) {
		this.product_sellcount = product_sellcount;
	}
	public List<ProductInfo> getProduct_clickcount() {
		return product_clickcount;
	}
	public void setProduct_clickcount(List<ProductInfo> product_clickcount) {
		this.product_clickcount = product_clickcount;
	}
	
	
	
}
