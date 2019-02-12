package site.yueyiqiu.action.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.OrderState;
import site.yueyiqiu.model.PageModel;
import site.yueyiqiu.model.order.Order;
import site.yueyiqiu.model.order.OrderItem;
import site.yueyiqiu.model.product.ProductInfo;
import site.yueyiqiu.util.StringUtil;

import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("orderAction")
public class OrderAction extends BaseAction implements ModelDriven<Order>{
	
	
	public String add(){
		
		if(this.getLoginCustomer()!=null){
		this.order.setName(this.getLoginCustomer().getUsername());
		this.order.setAddress(this.getLoginCustomer().getAddress());
		this.order.setMobile(this.getLoginCustomer().getMobile());
		return this.ADD;
		}
		
		return this.CUSTOMER_LOGIN;
	}
	
	public String confirm(){
		
		System.out.println("paymentway="+this.order.getPaymentWay().toString());
		return "confirm";
		
	}
	
	public String save(){
		
		//System.out.println("pay method="+this.order.getPaymentWay().getPayName());
		
		if(this.getLoginCustomer()!=null){
			
			
			this.order.setOrderId(StringUtil.createOrderId());
			this.order.setCustomer(this.getLoginCustomer());
			Set<OrderItem> cart=this.getCart();
			if(cart.isEmpty()){
				return this.ERROR;
			}
			
			
			
			for(OrderItem item:cart){
				
				
				int productId=item.getProductId();
				System.out.println("productId="+productId);
				ProductInfo product=this.productDao.load(productId);
				
				product.setSellCount(product.getSellCount()+item.getAmount());
				this.productDao.saveOrUpdate(product);
				item.setOrder(order);
			}
			
			System.out.println("out of for");
			System.out.println("name="+((OrderItem)cart.toArray()[0]).getOrder().getCustomer().getUsername());
			this.order.setOrderItems(cart);
			this.order.setOrderState(OrderState.DELIVERED);
			
			double total=0;
			
			for(OrderItem item:cart){
				
				total+=item.getProductPrice()*item.getAmount();
			}
			
			this.order.setTotalPrice(total);
			System.out.println("here");
			
			for(OrderItem item:cart){
				System.out.println("New pName="+item.getProductName());
			}
			int kkman=0;
//			for(OrderItem item:cart){
//				kkman++;
//				System.out.println("pName="+item.getProductName());
//				this.orderDao.save(item);
//			System.out.println("kkman="+kkman);	
//			}
			
			//OrderItem item=cart.iterator()
			
//			Iterator<OrderItem> kkk=cart.iterator();
//			
//			while(kkk.hasNext()){
//				
//				OrderItem item=kkk.next();
//				System.out.println("pName="+item.getProductName());
//				this.orderDao.save(item);
//			}
			
					
			
			
			System.out.println("middle");
			
			this.orderDao.save(order);
			System.out.println("end");
			session.remove("cart");
			this.orderDao.close();
		}
		return this.findByCustomer();
	}
	
	
	public String findByCustomer(){
		
		if(this.getLoginCustomer()!=null){
			String where="where customer.id=?";
			Object[] params={this.getLoginCustomer().getId()};
			Map<String,String> orderby=new HashMap<String,String>();
			orderby.put("createtime", "desc");
			this.pagemodel=this.orderDao.find(where, params, orderby, pageNo, pageSize);
			return this.LIST;
		}
		
		return this.CUSTOMER_LOGIN;
				
	}
	
	
	public String list(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("createtime", "desc");
		
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		
		if(this.order.getOrderId()!=null&&this.order.getOrderId().length()>0){
			sb.append("orderId=?");
			params.add(this.order.getOrderId());
		}
		
		if(this.order.getOrderState()!=null){
			System.out.println(this.order.getOrderState().getName());
			if(params.size()>0)
				sb.append(" and ");
			sb.append("orderState=?");
			params.add(this.order.getOrderState());
		}
		
		if(this.order.getCustomer()!=null&&this.order.getCustomer().getUsername()!=null&&this.order.getCustomer().getUsername().length()>0){
			if(params.size()>0)
				sb.append(" and ");
			sb.append("customer.username=?");
			params.add(this.order.getCustomer().getUsername());
		}
		
		if(this.order.getName()!=null&&this.order.getName().length()>0){
			if(params.size()>0)
				sb.append(" and ");
			sb.append("name=?");
			params.add(this.order.getName());
		}
		
		String where=sb.length()>0?"where "+sb.toString():"";
		
		//System.out.println(((OrderState)params.get(0)).getName());
		
		this.pagemodel=this.orderDao.find(where, params.toArray(), orderby, pageNo, pageSize);
		
		System.out.println(where);
		for(int i=0;i<this.pagemodel.getList().size();i++){
			System.out.println(this.pagemodel.getList().get(i).getName());
		}
		
		return this.LIST;
	}
	
	
	
	public String update(){
		
		OrderState state=this.order.getOrderState();
		System.out.println("id="+this.order.getOrderId());
		System.out.println("state name="+state.getName());
		Order order=this.orderDao.load(this.order.getOrderId());
		order.setOrderState(state);
		this.orderDao.update(order);
		return this.UPDATE;
	}
	
	
	private Order order=new Order();
	private PageModel<Order> pagemodel=new PageModel<Order>();
	
	
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return this.order;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public PageModel<Order> getPagemodel() {
		return pagemodel;
	}


	public void setPagemodel(PageModel<Order> pagemodel) {
		this.pagemodel = pagemodel;
	}
	
	
	

}
