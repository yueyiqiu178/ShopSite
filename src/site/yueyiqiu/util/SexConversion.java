package site.yueyiqiu.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import site.yueyiqiu.model.Sex;

public class SexConversion extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		System.out.println("Sex conversion start!!!!!!!");
		
		Sex[] sex=Sex.values();
		
		for(int i=0;i<values.length;i++){
			System.out.println("value="+values[i]);
		}
		
		for(Sex item:sex){
			if(item.getName().equals(values[0]))
				return item;
		}
		
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		
		Sex sex=(Sex) o;
		
		return sex.getName();
	}
	
}
