package site.yueyiqiu.model.order;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import site.yueyiqiu.model.OrderState;
import site.yueyiqiu.model.PaymentWay;
import site.yueyiqiu.model.user.Customer;

public class Order implements Serializable{
	
	private String orderId;
	private Customer customer;
	private String name;
	private String address;
	private String mobile;
	private Set<OrderItem> orderItems;
	private double totalPrice;
	private PaymentWay paymentWay;
	private OrderState orderState;
	private Date createtime=new Date();
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the paymentWay
	 */
	public PaymentWay getPaymentWay() {
		return paymentWay;
	}
	/**
	 * @param paymentWay the paymentWay to set
	 */
	public void setPaymentWay(PaymentWay paymentWay) {
		this.paymentWay = paymentWay;
	}
	
	
	
	
	
	
	
}
