package site.yueyiqiu.util.hibernate;

import site.yueyiqiu.model.PaymentWay;
import site.yueyiqiu.model.Sex;

public class PaymentWayType extends MyEnum<PaymentWay>{
	public PaymentWayType(){
		super(PaymentWay.class);
	}
}
