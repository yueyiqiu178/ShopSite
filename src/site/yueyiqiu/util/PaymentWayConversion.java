package site.yueyiqiu.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import site.yueyiqiu.model.PaymentWay;

public class PaymentWayConversion extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("value="+values[0]);
		
		
		if(values[0].toCharArray()[0]<=90&&values[0].toCharArray()[0]>=65){
			
			PaymentWay[] paymentways=PaymentWay.values();
			
			for(PaymentWay item:paymentways){
				
				if(item.toString().equals(values[0].trim())){
					//System.out.println("value="+values[0]);
						return item;}
			}
			System.out.println("return null");
			return null;
			
		}
		else{
			System.out.println("¤¤¤å");
			PaymentWay[] paymentways=PaymentWay.values();
			
			for(PaymentWay item:paymentways){
				
				if(item.getPayName().equals(values[0].trim())){
					//System.out.println("value="+values[0]);
						return item;}
			}
			System.out.println("return null");
			return null;
			
		}
		
		
		
	}

	@Override
	public String convertToString(Map context, Object o) {
		
		PaymentWay paymentway=(PaymentWay) o;
		
		return paymentway.getPayName();
	}
	
}
