package test.thread;

public class DeadLockThread {
	public static void main(String[] args) {
		System.out.println("主线程开始");
		
		final StringBuffer mutex = new StringBuffer("ABCD");
		Thread t = new Thread(){
			@Override
			public void run() {
				System.out.println("子线程开始");
				synchronized(mutex) {
					mutex.reverse();
				}
			}
		};
		t.start();
		
		
		/*try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		synchronized(mutex){
			System.out.println("进入同步锁");
			
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(mutex);
		}
		
	}
}
