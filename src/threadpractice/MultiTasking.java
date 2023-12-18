package threadpractice;

import java.io.IOException;

public class MultiTasking {
	int contr=1;
	static int NUM;
	public static void main(String[] args) throws IOException {
		NUM=20;
		MultiTasking m=new MultiTasking();
		Thread t1=new Thread(
				new Runnable() {

					@Override
					public void run() {
						m.displayOddNumber();
						
					}
					
				}
				);
		Thread t2=new Thread(
				new Runnable() {

					@Override
					public void run() {
						m.displayEvenNumber();
						
					}
					
				}
				);
		t1.start();
		t2.start();
	}
	public synchronized  void displayOddNumber() {
		while(contr<NUM) {
			while(contr%2!=0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(contr+ " ");
			contr++;
			notify();
		}
	}
		public synchronized  void displayEvenNumber() {
			while(contr<NUM) {
				while(contr%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(contr+ " ");
				contr++;
				notify();
			}
	}
}
