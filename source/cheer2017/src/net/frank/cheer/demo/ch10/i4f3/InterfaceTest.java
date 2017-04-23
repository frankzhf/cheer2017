package net.frank.cheer.demo.ch10.i4f3;

public class InterfaceTest {
	public static void main(String[] args){
		Wuqi _ak47 = new Ak47IImpl();
		Wuqi _tank = new TankImpl();
		
		
		_ak47.openFire();
		_tank.openFire();
		
	}
}
