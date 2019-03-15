package test.aop;

public class Zhangsan implements People {

	@Override
	public void eat() throws Throwable {
		System.out.println("吃饭的时候喜欢看《JAVA高级开发》");

	}

	@Override
	public void sleep() throws Throwable {
		System.out.println("睡觉的时候喜欢磨牙！");

	}

	@Override
	public void dadoudou() throws Throwable {
		System.out.println("喜欢和美女一起打豆豆！");

	}

}
