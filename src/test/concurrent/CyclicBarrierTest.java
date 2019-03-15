package test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int n = 4;
		CyclicBarrier barrier = new CyclicBarrier(n);
		for(int i=0; i<n; i++){
			Writer w = new Writer(barrier);
			w.start();
		}
	}
	
	static class Writer extends Thread{
		private CyclicBarrier c;
		public Writer(CyclicBarrier c){
			this.c = c;
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "开始");
			try {
				System.out.println(Thread.currentThread().getName() + "处理中");
				c.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "结束");
		}
	}
}
