package site.yueyiqiu.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import site.yueyiqiu.dao.order.OrderDao;
import site.yueyiqiu.dao.product.ProductCategoryDao;
import site.yueyiqiu.dao.product.ProductDao;
import site.yueyiqiu.dao.product.UploadFileDao;
import site.yueyiqiu.dao.user.CustomerDao;
import site.yueyiqiu.dao.user.UserDao;
import site.yueyiqiu.model.order.OrderItem;
import site.yueyiqiu.model.user.Customer;
import site.yueyiqiu.model.user.User;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	
	
	protected int pageNo=1;
	protected int pageSize=3;
	
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	
	@Autowired
	protected ProductCategoryDao categoryDao;
	@Autowired
	protected ProductDao productDao;
	@Autowired
	protected OrderDao orderDao;
	@Autowired
	protected UserDao userDao;
	@Autowired
	protected CustomerDao customerDao;
	@Autowired
	protected UploadFileDao uploadFileDao;
	
	
	
	
	public static final String LIST="list";
	public static final String INDEX="index";
	public static final String USER_LOGIN="userLogin";
	public static final String CUSTOMER_LOGIN="customerLogin";
	public static final String LOGOUT="logout";
	public static final String MANAGER="manager";
	public static final String REG="reg";
	public static final String MAIN="main";
	public static final String TOP="top";
	public static final String ADD="add";
	public static final String SELECT="select";
	public static final String SUCCESS="success";
	public static final String LEFT="left";
	public static final String RIGHT="right";
	public static final String QUERY="query";
	public static final String EDIT="edit";
	public static final String CLICKLIST="clicklist";
	public static final String FINDLIST="findlist";
	public static final String UPDATE="update";
	public static final String SELL="sell";
	public static final String ENJOY="enjoy";
	public static final String COMMEND="commend";
	
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	
	protected Set<OrderItem> getCart(){
		Object obj=session.get("cart");
		if(obj==null)
			return new HashSet<OrderItem>();
		else
			return (HashSet<OrderItem>)obj;
	}
	
	protected Customer getLoginCustomer(){
		
		if(session.get("customer")!=null)
			return (Customer) session.get("customer");
		
			return null;
	}
	
	protected User getLoginUser(){
		
		if(session.get("admin")!=null)
			return (User) session.get("admin");
			
			return null;
		
	}
	
	
	public String index(){
		return this.INDEX;
	}
	
	public String manager(){
		return this.MANAGER;
	}
	
	public String main(){
		return this.MAIN;
	}
	
	public String add(){
		return this.ADD;
	}
	
	public String select(){
		return this.SELECT;
	}
	
	public String left(){
		return this.LEFT;
	}
	
	public String right(){
		return this.RIGHT;
	}
	
	public String edit(){
		return this.EDIT;
	}
	
	public String query(){
		return this.QUERY;
	}
	
	public String top(){
		return this.TOP;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
