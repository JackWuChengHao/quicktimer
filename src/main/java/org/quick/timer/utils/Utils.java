package org.quick.timer.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.quick.timer.annotation.TimerMethod;
import org.quick.timer.bean.TimerMetaBean;

import test.ok;




public class Utils {
	
	static List<TimerMetaBean> timerMetaBeanList(Class<?> clz) {
		
		List<TimerMetaBean> timerMetaBeanList = new ArrayList<TimerMetaBean>();
		 
		for (Class<?> clazz = clz; clazz != Object.class; clazz = clazz.getSuperclass()) {
			Method[] metds= clazz.getDeclaredMethods();
			for(Method method : metds) {
				if(method.isAnnotationPresent(TimerMethod.class)) {
					TimerMethod tm = method.getAnnotation(TimerMethod.class);
					timerMetaBeanList.add(
					new TimerMetaBean(clazz,method,tm.IntervalTime()));
				}
			}
        }
		return timerMetaBeanList;
	}
	
	
	static void dotheTimerMetaBean(List<TimerMetaBean> timerMetaBeanList) {
		for(TimerMetaBean timerMetaBean : timerMetaBeanList) {
			
			try {
				timerMetaBean.getMethod().invoke(null, null);
				System.out.println(timerMetaBean.getTime());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		Utils.dotheTimerMetaBean(Utils.timerMetaBeanList(ok.class));
		
	}
	
}
