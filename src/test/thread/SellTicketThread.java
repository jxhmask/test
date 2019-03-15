package test.thread;

import java.util.HashMap;
import java.util.Hashtable;

public class SellTicketThread {
	public static void main(String[] args) {
		
		Hashtable<, V>
		HashMap<Integer, Object> m = new HashMap<Integer, Object>();
		Runnable r = new sellTicket();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		Thread t3 = new Thread(r, "t3");
		t1.start();
		t2.start();
		t3.start();
	}
	
	 static class sellTicket implements Runnable{
		private Integer i = 10;
		@Override
		public void run() {
			synchronized (this) {	
				while(i > 0){
					i--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "_" + i);
				}
			}
		}
		 
	 }
}
