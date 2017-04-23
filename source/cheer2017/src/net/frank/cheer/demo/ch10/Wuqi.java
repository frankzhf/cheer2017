package net.frank.cheer.demo.ch10;

public abstract class Wuqi {
	
	public abstract void openFire();
	
	public static void main(String[] args){
		Wuqi _ak47 = new Ak47();
		Wuqi _tank = new Tank();
		
		
		_ak47.openFire();
		_tank.openFire();
		
		
	}
	
	
}
