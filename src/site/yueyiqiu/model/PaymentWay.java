package site.yueyiqiu.model;

import java.util.ArrayList;
import java.util.List;

public enum PaymentWay {
	NET_BANK{

		@Override
		public String getPayName() {
			
			return "½u¤W»È¦æ¥I´Ú";
		}},
	ALIPAY{

		@Override
		public String getPayName() {
			
			return "¤ä¥IÄ_";
		}},
		
		FINISH_PAY{

			@Override
			public String getPayName() {
				// TODO Auto-generated method stub
				return "³f¨ì¥I´Ú";
			}},
			
			POSTOFFICE_PAY{

			@Override
			public String getPayName() {
				// TODO Auto-generated method stub
				return "¶l§½¶×´Ú";
			}};
	
	public abstract String getPayName();
	
	public static List<PaymentWay> getValues(){
		List<PaymentWay> list=new ArrayList<PaymentWay>();
		for(PaymentWay item:PaymentWay.values()){
			list.add(item);
		}
		return list;
	}
	
}
