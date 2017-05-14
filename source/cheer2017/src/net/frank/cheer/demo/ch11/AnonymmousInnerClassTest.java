package net.frank.cheer.demo.ch11;

public class AnonymmousInnerClassTest {
	
	public AnonymmousInnerClassTest(final Integer ak47AttackValue,final Integer tankAttackValue){
		Wuqi ak47 = new Wuqi(){
			@Override
			public void openFire() {
				System.out.println("Ak47 openFire...., attacked human lift value will down " + ak47AttackValue);
			}
		};
		
		Wuqi tank = new Wuqi(){

			@Override
			public void openFire() {
				System.out.println("Ak47 openFire...., attacked human lift value will down " + tankAttackValue);
			}
		};
		ak47.openFire();
		tank.openFire();
	}
	
	public static void main(String[] args){
		AnonymmousInnerClassTest test = new AnonymmousInnerClassTest(100,1000);
		System.out.println(test);
	}
	
	
}
