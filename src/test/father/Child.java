package test.father;

public class Child extends Father{
	
	public void say(){
		System.out.println("i am child");
	}
//	
//	public void getSay(){
//		say();
//	}
	
	public static void main(String[] args) {
		Child c = new Child();
		//c.say();
		c.getSay();
		
		Father f = new Father();
		//f.say();
		f.getSay();
	}
}
