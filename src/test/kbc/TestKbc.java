package test.kbc;

public class TestKbc {
	public static void main(String[] args) {  
		//测试，传入多个参数  
		//test("hello", "world", "13sd", "china", "cum", "ict");  
		int a,b,c;
		c = 3;
		a = b = c;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}  
		  
	//可变长度参数
	public static void test(String... arguments) {  
		System.out.println(arguments[3]);
		/*for (int i = 0; i < arguments.length; i++) {  
			System.out.println(arguments[i]);  
		}  */
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
