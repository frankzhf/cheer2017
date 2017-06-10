package net.frank.cheer.demo.ch18;

//import java.util.HashMap;
//import java.util.Map;

public class ThreadLocalTest {
	
	private static ThreadLocal<User> userThreadLoacl = new ThreadLocal<User>();
	
	//private static Map<Long,User> userMap = new HashMap<Long,User>();
	
	public static void main(String[] args) {
		for(int i=1;i<100;i++){
			final int index= i;
			new Thread(new Runnable(){
				@Override
				public void run() {
					User user= new User();
					user.setName("tester" + index);
					userThreadLoacl.set(user);
					// userMap.put(Thread.currentThread().getId(),user);
					a();
					b();
					c();
					d();
				}
			}).start();
		}
	}

	private static void a(){
		// userMap.get(Thread.currentThread().getId());
		User currentUser = userThreadLoacl.get();
		System.out.println(currentUser.getName() + "Called a method...");
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
	}
	private static void b(){
		User currentUser = userThreadLoacl.get();
		System.out.println(currentUser.getName() + "Called b method...");
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
	}
	private static void c(){
		User currentUser = userThreadLoacl.get();
		System.out.println(currentUser.getName() + "Called c method...");
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
	}
	private static void d(){
		User currentUser = userThreadLoacl.get();
		System.out.println(currentUser.getName() + "Called d method...");
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
	}
}

class User{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

