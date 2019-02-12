package site.yueyiqiu.util.hibernate;

import site.yueyiqiu.model.OrderState;
import site.yueyiqiu.model.Sex;

public class OrderStateType extends MyEnum<OrderState>{
	public OrderStateType(){
		super(OrderState.class);
	}
}
