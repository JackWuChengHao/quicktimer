package test;

import org.quick.timer.annotation.TimerMethod;

public class ok {
	
	@TimerMethod(IntervalTime=100)
	public static void okok() {
		System.out.println("123123");
	}
	
	@TimerMethod()
	public static void www() {
		System.out.println("okokok");
	}
}
