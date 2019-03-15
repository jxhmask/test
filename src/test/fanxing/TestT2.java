package test.fanxing;

import java.util.List;

public class TestT2 {
	
	public  <T extends Number>void print(T o){
		System.out.println(o.getClass().getName());
	}
	
	
	public void printTpf(List<? extends Number> n){
		
	}
	
	public void printTpf2(List<? super Number> n){
		
	}
	public static void main(String[] args) {
		TestT2 t = new TestT2();
		t.print(123.56);
		t.print(1243);
		
		Number n = new Integer(1);
		System.out.println(n);
	}
}
