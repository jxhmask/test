package test.aop;

public class Zhangsan implements People {

	@Override
	public void eat() throws Throwable {
		System.out.println("�Է���ʱ��ϲ������JAVA�߼�������");

	}

	@Override
	public void sleep() throws Throwable {
		System.out.println("˯����ʱ��ϲ��ĥ����");

	}

	@Override
	public void dadoudou() throws Throwable {
		System.out.println("ϲ������Ůһ��򶹶���");

	}

}
