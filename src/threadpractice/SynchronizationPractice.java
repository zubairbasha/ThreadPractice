package threadpractice;

public class SynchronizationPractice {
	public static void main(String[] args) {
		Table t=new Table();
		MyThread1 t1=new MyThread1(t);
		MyThread2 t2=new MyThread2(t);
		t1.start();
		t2.start();
	}
}

class Table {
	 void printTable(int n) {
		synchronized(this){
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 }

	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}
}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}
