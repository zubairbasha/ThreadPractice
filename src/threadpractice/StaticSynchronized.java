package threadpractice;

public class StaticSynchronized {
	public static void main(String[] args) {
		TableThread1 t1=new TableThread1();
		TableThread2 t2=new TableThread2();
		t1.start();
		t2.start();
	}
}

class TablePrint {
	synchronized static void printTable(int n) {
		for(int i=1;i<=10;i++) {
			System.out.println(n*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class TableThread1 extends Thread{
	public void run() {
		TablePrint.printTable(5);
	}
}
class TableThread2 extends Thread{
	public void run() {
		TablePrint.printTable(3);
	}
}
