package com.maggie.s4.card;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;


public class Card {
	public void cardCheck() {
		System.out.println("카드 찍기 ");
		System.out.println("beep beep");
	}
	
	@Around("execution(* com.choa.s4.transfer.*.take*(..))")
	public Object transferCard(ProceedingJoinPoint join) {
		System.out.println("승차 전 카드 찍기 ");
		Object obj = null;
		try {
			Object [] arr = join.getArgs();
			for(Object o:arr) {
				System.out.println(o);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("하차 후 카드 찍기 ");
		return obj;
	}
}
