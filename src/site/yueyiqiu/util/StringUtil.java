package site.yueyiqiu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {
	
	public static Random rand=new Random();
	
	public static String getStringTime(){
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		return sdf.format(date);
		
	}
	
	public static String createOrderId(){
		
		StringBuffer sb=new StringBuffer();
		sb.append(getStringTime());
		for(int i=1;i<=3;i++){
			sb.append(rand.nextInt(9));
		}
		return sb.toString();
	}
	
}
