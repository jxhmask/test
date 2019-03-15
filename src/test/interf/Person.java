package test.interf;

public class Person implements Play {
	static int b = 3;
	static int a = 4;
	public void setterB(int i){
		b = i;
	}
	
	
	
	
	//int a = 2;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Person p = new Person();
//		System.out.println(p.a);
//		System.out.println(Person.a);
//		int b = Person.a + 1;
		Person.b = 434;
		System.out.println(Play.a + "  " + Person.a);
		//p.setterB(6);
		System.out.println(Person.b);
	}
}
