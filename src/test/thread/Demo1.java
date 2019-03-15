package test.thread;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Thread t = new MyThead();
		t.start();
		
		int total = 0;
		for(int i = 0; i < 1000; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			total = total + i;
		}
		System.out.println(total);	
		
	}
}


class MyThead extends Thread{
	@Override
	public void run() {
		Scanner s = new Scanner(System.in);
		String str;
		while(!(str = s.next()).equals("quit")){
			System.out.println(str);
		}
	}
	
}