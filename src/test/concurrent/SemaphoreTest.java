package test.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，
 * 只有使用完了，其他工人才能继续使用。那么我们就可以通过Semaphore来实现：
 * @author Administrator
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		int n = 8;//工人数
		Semaphore semaphore = new Semaphore(5);//5台机器
		for(int i=1; i<n; i++){
			new Worker(i, semaphore).start();
		}			
	}
	
	static class Worker extends Thread{
		private int n;
		private Semaphore semaphore;
		public Worker(int n, Semaphore semaphore){
			this.n = n;
			this.semaphore = semaphore;
		}
		
		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人：" + n + ",开始工作");
				Thread.sleep(n*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("工人：" + n + ",结束工作");
			semaphore.release();
		}
	}
}
