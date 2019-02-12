package site.yueyiqiu.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import site.yueyiqiu.model.OrderState;

public class OrderStateConversion extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		System.out.println("enter conversion!!");
		
		for(int i=0;i<values.length;i++){
			System.out.println("value="+values[i]);
		}
		
		OrderState[] orderstates=OrderState.values();
		
		for(OrderState item:orderstates){
			if(item.toString().equals(values[0].toString()))
				return item;
		}
		
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		
		OrderState orderstate=(OrderState) o;
		
		return orderstate.getName();
	}
	
}
