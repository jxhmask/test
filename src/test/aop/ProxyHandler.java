package test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	
	//����ӿڲ���
	People people = null;
	public ProxyHandler(People people){		
		this.people = people;
	}

	/***
	 * ���ǿ����ľ���ִ�еķ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//ǰ����չģ��
		before();
		method.invoke(people, null);
		after();
		return null;
	}

	//ǰ����չģ��
	private void after() {
		System.out.println("Ҫ�����ˣ���ϲ����ʲô��");
	}

	//������չģ��
	private void before() {
		System.out.println("�����ˣ�����ʰһ���ˣ�");
	}

	
}
