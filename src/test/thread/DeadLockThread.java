package test.thread;

public class DeadLockThread {
	public static void main(String[] args) {
		System.out.println("���߳̿�ʼ");
		
		final StringBuffer mutex = new StringBuffer("ABCD");
		Thread t = new Thread(){
			@Override
			public void run() {
				System.out.println("���߳̿�ʼ");
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
			System.out.println("����ͬ����");
			
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
