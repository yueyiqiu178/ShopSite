package site.yueyiqiu.model.product;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class ProductCategory implements Serializable{
	
	private int id;
	private String name;
	private int level=1;
	private Set<ProductCategory> children;
	private ProductCategory parent;
	private Set<ProductInfo> products=new TreeSet<ProductInfo>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the children
	 */
	public Set<ProductCategory> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<ProductCategory> children) {
		this.children = children;
	}
	/**
	 * @return the parent
	 */
	public ProductCategory getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}
	/**
	 * @return the product
	 */
	public Set<ProductInfo> getProduct() {
		return products;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Set<ProductInfo> products) {
		this.products = products;
	}
	public Set<ProductInfo> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductInfo> products) {
		this.products = products;
	}
		
}
