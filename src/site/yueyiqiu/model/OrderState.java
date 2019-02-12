package site.yueyiqiu.model;

import java.util.ArrayList;
import java.util.List;

public enum OrderState {
	
	DELIVERED{
		public String getName(){return "已發貨";}
	},FINISH{
		public String getName(){return "交易完成";}
	},CANEL{
		
		public String getName(){return "交易取消";}
	};
	
	
	public abstract String getName();
	
	public static List<OrderState> getValues(){
		List<OrderState> list=new ArrayList<OrderState>();
		for(OrderState ptr:OrderState.values()){
			list.add(ptr);
		}
		return list;
	} 
	
	
}
