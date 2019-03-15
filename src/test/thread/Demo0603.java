package test.thread;

public class Demo0603 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(), "t1");
		t1.start();
		try {
			t1.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(new MyThread(), "t2");
		t2.start();
		try {
			t2.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 100; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%10 == 0)
			System.out.println(Thread.currentThread().getName() + "_" + i/10);
		}
		
	}
	
}
