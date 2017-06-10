package net.frank.cheer.demo.ch18;

public class MyFirstThreadTest {
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			MyFirstThread myFirstThread = new MyFirstThread(i);
			myFirstThread.run();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Not Threads run, count time is " + (endTime - startTime));
	
		
		startTime = System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			MyFirstThread myFirstThread = new MyFirstThread(i,startTime);
			myFirstThread.start();
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Threads assigned, count time is " + (endTime - startTime));
	}
	
}


class MyFirstThread extends Thread{
	
	private int value;
	private long startTime;
	
	public MyFirstThread(int value){
		this.value = value;
	}
	
	public MyFirstThread(int value, long startTime){
		this.value = value;
		this.startTime = startTime;
	}
	
	@Override
	public void run(){
		try{
			Thread.sleep(1000);
			System.out.println(value);
			if(startTime!=0){
				long endTime = System.currentTimeMillis();
				System.out.println("Current Thread [value] ->" + value +" execute end cast " + (endTime - startTime) + "millsecond(s)" );
			}
		}catch(InterruptedException e){			
		}
	}
}