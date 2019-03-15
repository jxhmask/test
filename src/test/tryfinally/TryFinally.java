package test.tryfinally;

public class TryFinally {
	public int get(){
		try{
			int a = 2;
			return a;
		}finally{
			System.out.println("hello");
		}
	}
	
	public static void main(String[] args) {
		TryFinally tf = new TryFinally();
		
		System.out.println(tf.get());
	}
}
