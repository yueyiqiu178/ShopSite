package site.yueyiqiu.model;

import java.util.ArrayList;
import java.util.List;

public enum PaymentWay {
	NET_BANK{

		@Override
		public String getPayName() {
			
			return "�u�W�Ȧ�I��";
		}},
	ALIPAY{

		@Override
		public String getPayName() {
			
			return "��I�_";
		}},
		
		FINISH_PAY{

			@Override
			public String getPayName() {
				// TODO Auto-generated method stub
				return "�f��I��";
			}},
			
			POSTOFFICE_PAY{

			@Override
			public String getPayName() {
				// TODO Auto-generated method stub
				return "�l���״�";
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
