package site.yueyiqiu.util;

import site.yueyiqiu.model.OrderState;

public class MyTest {

	public static void main(String[] args) {
		
		System.out.println(OrderState.DELIVERED.getName());
		System.out.println(OrderState.DELIVERED);
		
		OrderState[] state=OrderState.values();
		OrderState kkman=OrderState.FINISH;
		System.out.println(state[2].toString());
		
		
		
	}

}
