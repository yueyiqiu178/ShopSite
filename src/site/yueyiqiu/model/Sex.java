package site.yueyiqiu.model;

import java.util.ArrayList;
import java.util.List;

public enum Sex {
	
	BOY{
		
		public String getName(){return "男";}
		
	},
	GIRL{
		
		public String getName(){return "女";}
	},
	ALL{
		
		public String getName(){return "不分";}
		};
	
	
	public abstract String getName();
	
	public static List<Sex> getValues(){
		List<Sex> list=new ArrayList<Sex>();
		for(Sex sex:Sex.values()){
			list.add(sex);
		}
		return list;
	}
	
}
