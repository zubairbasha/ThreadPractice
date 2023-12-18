package threadpractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(5);
		for(int i=1;i<=10;i++) {
			Runnable worker =new WorkerThread(" "+i);
			service.execute(worker);
		}
		service.shutdown();
		
	}
}
class WorkerThread implements Runnable{
	private String message;
	public WorkerThread(String message) {
		this.message=message;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
	}
	private void processmessage() {  
        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
	
}
