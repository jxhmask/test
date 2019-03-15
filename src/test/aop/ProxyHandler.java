package test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	
	//传入接口参数
	People people = null;
	public ProxyHandler(People people){		
		this.people = people;
	}

	/***
	 * 你们看到的具体执行的方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//前置扩展模块
		before();
		method.invoke(people, null);
		after();
		return null;
	}

	//前置扩展模块
	private void after() {
		System.out.println("要做饭了，你喜欢吃什么？");
	}

	//后置扩展模块
	private void before() {
		System.out.println("吃完了，该收拾一下了！");
	}

	
}
