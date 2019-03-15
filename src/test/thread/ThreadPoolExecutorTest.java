package test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws InterruptedException {
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		
//		
//		ThreadA a = new ThreadA();
//		ThreadA b = new ThreadA();
//		ThreadA c = new ThreadA();
//		
//		executorService.execute(a);
//		executorService.execute(b);
//		executorService.execute(c);
		
		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                2,
                1,
                TimeUnit.SECONDS,
                queue);
		ThreadA a = new ThreadA("a");
		ThreadA b = new ThreadA("b");
		ThreadA c = new ThreadA("c");
		
		threadPoolExecutor.execute(a);
		threadPoolExecutor.execute(b);
		threadPoolExecutor.execute(c);
		
		Thread.sleep(1000);
		a.interrupt();
		
		System.out.println(queue.toString());
		
		queue.remove(c);
		System.out.println(queue.toString());
		
		
	}
}


class ThreadA extends Thread{

	boolean flag = true;
	public ThreadA(String name) {
		super(name);
	}
	@Override
	public void run() {
		int i = 1;
		while(flag){
//			System.out.println(i++);
			if(this.isInterrupted()){
				flag = false;
			}
		}
		
	}
	
}