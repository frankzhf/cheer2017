package net.frank.cheer.demo.ch18;

public class SynchronizedTest {
	
	public static void main(String[] args){
		final Account zhangsan = new Account();
		for(int i=0;i<10;i++){
			final int payValue = 4000;
			Thread trade = new Thread(new Runnable(){
				@Override
				public void run() {
					System.out.println("Trade-ID" + this +" Begin");
					if(zhangsan.check(payValue)){
						System.out.println("Trade-ID" + this +", Trade Success.");
					}else{
						System.out.println("Trade-ID" + this +", value not enough Trade failure.");
					}
					System.out.println("Trade-ID" + this +" end, its value is" + zhangsan.getValue());
				}
			});
			trade.start();
		}
		try{
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Account current Value =" + zhangsan.getValue());
	}
}

class Account{
	private int value =10000;
	public  boolean check(int payValue){
		synchronized(this){
			if(payValue<value){
				try{
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				value -= payValue;
				
				System.out.println("Account current Value =" + getValue());
				return true;
			}else{
				return false;
			}
		}
	}
	
	public int getValue(){
		return value;
	}
	
}