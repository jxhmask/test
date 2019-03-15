package test.concurrent;

import java.util.concurrent.Semaphore;

/**
 * ����һ��������5̨������������8�����ˣ�һ̨����ͬʱֻ�ܱ�һ������ʹ�ã�
 * ֻ��ʹ�����ˣ��������˲��ܼ���ʹ�á���ô���ǾͿ���ͨ��Semaphore��ʵ�֣�
 * @author Administrator
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		int n = 8;//������
		Semaphore semaphore = new Semaphore(5);//5̨����
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
				System.out.println("���ˣ�" + n + ",��ʼ����");
				Thread.sleep(n*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���ˣ�" + n + ",��������");
			semaphore.release();
		}
	}
}
