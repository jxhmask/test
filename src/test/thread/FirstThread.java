package test.thread;

public class FirstThread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());//���̵߳�����
		Thread t =  new HelloThread(100);
		//t.start();//������һ�����߳�
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