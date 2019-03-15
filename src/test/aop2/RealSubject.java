package test.aop2;

public class RealSubject implements Subject, SubjectEat  {   
	  public void doSomething(String thing)  {   
	    System.out.println( "call doSomething()" + thing);   
	  }

	@Override
	public void eat(String food) {
		System.out.println("I eat " + food); 		
	}   
}   
