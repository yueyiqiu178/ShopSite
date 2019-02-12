package site.yueyiqiu.model;

import java.util.ArrayList;
import java.util.List;

public enum OrderState {
	
	DELIVERED{
		public String getName(){return "�w�o�f";}
	},FINISH{
		public String getName(){return "�������";}
	},CANEL{
		
		public String getName(){return "�������";}
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
