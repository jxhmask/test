package test.trycatch;

public class TestTryCatch {

	
	
	public static void main(String[] args) {
		try{
			
			int a = 1/0;
			
			System.out.println("adsfasd");
		}catch(Exception e){
			System.out.println("RuntimeException");
		}
	}
}
