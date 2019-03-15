package test.aop;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		People people = (People)Proxy.newProxyInstance(People.class.getClassLoader(),
				new Class[]{People.class}, new ProxyHandler(new Zhangsan()));
		try {
			people.eat();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
