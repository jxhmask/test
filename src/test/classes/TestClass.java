package test.classes;

import org.junit.Test;

public class TestClass {
	@Test
	public void testClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Student t = new Student();
		Class c = Class.forName("test.classes.Student");
		Student t2 = (Student)c.newInstance();
		System.out.println(t2);
	}
}
