package org.quick.timer.bean;
import java.io.Serializable;
import java.lang.reflect.Method;

public class TimerMetaBean implements Serializable{
	
	private static final long serialVersionUID = -2192658880543533451L;

	private Class<?> clz;
	
	private Method method;
	
	private int time;
	
	public TimerMetaBean(Class<?> clz,Method method,int time){
		this.clz = clz;
		this.method = method;
		this.time = time;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TimerMetaBean [clz=" + clz + ", method=" + method +  ", time=" + time + "]";
	} 
	
	
}
