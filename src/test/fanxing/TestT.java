package test.fanxing;

import java.util.ArrayList;
import java.util.Date;


public class TestT<T extends Comparable<T>>{
	private T min;
	private T max;
	
	public TestT(T min, T max){
		this.max = max;
		this.min = min;
	}
	
	
	
	public T getMin() {
		return min;
	}
	public void setMin(T min) {
		this.min = min;
	}
	public T getMax() {
		return max;
	}
	public void setMax(T max) {
		this.max = max;
	}
	
	
	
	public static void main(String[] args) {
		TestT t = new TestT("1", new Date());
		t.getMax().compareTo(t.getMin());
		System.out.println("max:" + t.max);
		System.out.println("min:" + t.min);
		
		
	}
	
}
