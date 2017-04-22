package net.frank.cheer.demo.ch08;

public abstract class AbstractJob {
	
	public abstract void doSome();
	
	public void doBusiness(){
		coneect();
		
		doSome();
		
		close();
		
	}
	
	private void coneect(){
		
	}
	
	private void close(){
		
	}
	
	
	
}

class LoginJob extends AbstractJob{

	@Override
	public void doSome() {
		// TODO Auto-generated method stub
		
	}
	
}