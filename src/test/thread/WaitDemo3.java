package test.thread;

public class WaitDemo3 {
	public static void main(String[] args) {
		GoDown goDown = new GoDown();
		Producer p1 = new Producer(goDown, 50);
		Producer p2 = new Producer(goDown, 10);
		Producer p3 = new Producer(goDown, 20);
		Producer p4 = new Producer(goDown, 30);
		Customer c1 = new Customer(goDown, 20);
		Customer c2 = new Customer(goDown, 40);
		Customer c3 = new Customer(goDown, 50);
		Customer c4 = new Customer(goDown, 10);
		Customer c5 = new Customer(goDown, 200);
		new Thread(p1, "p1").start();
		new Thread(p2, "p2").start();
		new Thread(p3, "p3").start();
		new Thread(p4, "p4").start();
		/*new Thread(c1, "c1").start();
		new Thread(c2, "c2").start();
		new Thread(c3, "c3").start();
		new Thread(c4, "c4").start();
		new Thread(c5, "c5").start();*/
	}
}

class GoDown{
	private int kc = 30;
	private final int KC_MAX = 100;
	
	public synchronized void produce(int num){
		//线程  判断要用  while，不能使用 if
		while(kc + num > KC_MAX){
			System.out.println(Thread.currentThread().getName() + "超出库存");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		kc = kc + num;
		System.out.println(Thread.currentThread().getName() + "生产了" + num + ",剩余" + kc);
		notifyAll();	
	}
	
	public synchronized void custome(int num){
		while(kc - num < 0){
			System.out.println(Thread.currentThread().getName() + "没有库存");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		kc = kc - num;
		System.out.println(Thread.currentThread().getName() + "消费了" + num + ",剩余" + kc);
		notifyAll();	
	}
	
}

class Producer implements Runnable{
	private GoDown goDown;
	private int num;
	public Producer(GoDown goDown, int num){
		this.goDown = goDown;
		this.num = num;
	}
	@Override
	public void run() {
		goDown.produce(num);
		
	}
}

class Customer implements Runnable{
	private GoDown goDown;
	private int num;
	public Customer(GoDown goDown, int num){
		this.goDown = goDown;
		this.num = num;
	}
	@Override
	public void run() {
		goDown.custome(num);
		
	}
}

