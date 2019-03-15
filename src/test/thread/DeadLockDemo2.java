package test.thread;

import java.util.Arrays;

public class DeadLockDemo2 {
	
	public static void main(String[] args) {
		
			
			char[] c1 = {'A', 'B', 'C', 'D'};
			char[] c2 = {'1', '2', '3', '4'};
			
			Thread t1 = new MyThread_lock(c1, c2);
			t1.start();
			Thread t2 = new MyThread_lock(c2, c1);
			t2.start();
	}
}

class MyThread_lock extends Thread{
	private char[] source;
	private char[] dest;
	
	public MyThread_lock(char[] source, char[] dest){
		this.source = source;
		this.dest = dest;
	}
	
	@Override
	public void run() {
		System.out.println(this.getName() + "线程开始");
		synchronized(source){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (dest) {
				dest = Arrays.copyOf(source, source.length);
			}
		}
		System.out.println(this.getName() + "线程结束");
	}
}
