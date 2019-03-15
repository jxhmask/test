package test.abstractdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InitDemo extends AbstractDemo{
	public InitDemo(){
		System.out.println("invoke InitDemo");
		super.i = 2;
	}
	
	public void hello(){
		
	}
	
	public static void main(String[] args) {
//		AbstractDemo ad = new InitDemo();
//		System.out.println(ad.getI());
		try {
			Method m = InitDemo.class.getMethod("hello", null);
			System.out.println(m.getModifiers());
			System.out.println(Modifier.isPublic(m.getModifiers()));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
