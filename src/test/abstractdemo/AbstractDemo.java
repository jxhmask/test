package test.abstractdemo;

public abstract class AbstractDemo {
	
	public Integer i;
	
	public AbstractDemo() {
		System.out.println("invoke AbstractDemo");
	}
	
	public static void main(String[] args) {
		
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}
	
	
	
}
