package site.yueyiqiu.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.user.Customer;
import site.yueyiqiu.util.AppException;

@Scope("prototype")
@Controller("customerAction")
public class CustomerAction extends BaseAction implements ModelDriven<Customer>{
	
	private static final long serialVersionUID = 1L;
	
	public String login(){
		
		return this.CUSTOMER_LOGIN;
		
	}
	
	
	public String save(){
		
		boolean unique=this.customerDao.isUnique(customer.getUsername());
		
		if(unique){
			
			this.customerDao.save(customer);
			return this.CUSTOMER_LOGIN;
		}
		else{
			
			throw new AppException("此用戶名不可用");
			
		}
		
	}
	
	
	
	public String logon(){
		
		Customer customer=this.customerDao.login(this.customer.getUsername().trim(), this.customer.getPassword().trim());
		System.out.println(this.customer.getUsername());
		System.out.println(this.customer.getPassword());
		if(customer!=null){
			session.put("customer", customer);}
		else{
			System.out.println("pppp");
			this.addFieldError("", "帳號或密碼不正確");
			return this.CUSTOMER_LOGIN;
		}
		
		return this.INDEX;
		
	}
	
	
	public String reg(){
		
		return this.REG;
		
		
	}
	
	
	public String logout(){
		
		session.remove("customer");
	
		return this.INDEX;
		
	}
	
	
	private Customer customer=new Customer();
	private String repassword;
	
	
	
	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}




	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	/**
	 * @return the repassword
	 */
	public String getRepassword() {
		return repassword;
	}




	/**
	 * @param repassword the repassword to set
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}




	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return this.customer;
	}
	
	
	
	
	
}
