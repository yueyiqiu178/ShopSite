package site.yueyiqiu.action.order;

import java.util.Iterator;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.order.OrderItem;
import site.yueyiqiu.model.product.ProductInfo;

@Scope("prototype")
@Controller("cartAction")
public class CartAction extends BaseAction{
	
	public String add(){
		if(this.productId>0){
			
			Set<OrderItem> cart=this.getCart();
			boolean same = false;
			
			for(OrderItem item:cart){
				if(item.getProductId()==this.productId){
					item.setAmount(item.getAmount()+1);
					same=true;
				}
					
			}
		
		
		
		if(!same){
			OrderItem oi=new OrderItem();
			ProductInfo pi=this.productDao.load(this.productId);
			oi.setProductId(pi.getId());
			oi.setProductName(pi.getName());
			oi.setProductPrice(pi.getSalePrice());
			oi.setProductMarketPrice(pi.getMarketPrice());
			cart.add(oi);
		}
		
		session.put("cart", cart);
		
		}
		
		return this.LIST;
	}
	
	
	public String delete(){
		
		Set<OrderItem> cart=this.getCart();
		OrderItem item;
		Iterator<OrderItem> iterator=cart.iterator();
		
		while(iterator.hasNext()){
			item=iterator.next();
			
			if(item.getProductId()==this.productId)
				iterator.remove();
		}
		
		this.session.put("cart", cart);
		return this.LIST;
		
	}
	
	
	public String list(){
		return this.LIST;
	}
	
	public String clear(){
		session.remove("cart");
		return this.LIST;
	}
	
	
	private int productId;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
