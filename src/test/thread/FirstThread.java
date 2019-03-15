package test.thread;

public class FirstThread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());//主线程的名称
		Thread t =  new HelloThread(100);
		//t.start();//创建了一个子线程
		t.run();
		/*Thread t1 =  new HelloThread(100);
		t1.start();*/
	}
}

class HelloThread extends Thread{
	private long max;
	
	public HelloThread(long max){
		this.max = max;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < max; i++){
			System.out.println(Thread.currentThread().getName() + "_" + i);
		}
	}
}


class GoodbyeThead implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}