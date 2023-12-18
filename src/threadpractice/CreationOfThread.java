package threadpractice;

public class CreationOfThread {
	public static void main(String[] args) throws InterruptedException {
	Task t1=new Task();
	Task2 t2=new Task2();
	Thread th=new Thread(t1,"Task 1");
	Thread th2=new Thread(t2,"Task 2");
	th.start();
	//Join method is used to wait the Current thread to complete.
	//It will not allow other thread to run untill it dies.
	th.join();
	th2.start();
	
	}
}

class Task implements Runnable {
	//
	public void run() {

		System.out.println("Running Task 1");
		try {
			Thread.sleep(2000);
			System.out.println("Current Thread" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 1 Ended");
	}
}

class Task2 implements Runnable {
	public void run() {

		System.out.println("Running Task 2");
		try {
			Thread.sleep(2000);
			System.out.println("Current Thread" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 2 Ended");
	}
}
