package net.frank.cheer.demo.ch11;

public class FinalTest {

	private static String value="abc";
	
	public static void main(String[] args) {
		FinalDemo finalDemo = new FinalDemo();
		finalDemo.setDemoValue("abc");
		System.out.println(finalDemo.getDemoValue());
		System.out.println(finalDemo); //net.frank.cheer.demo.ch11.FinalDemo@0xffffff
		/***
		 * if override toString method
		 * print toString method's result
		 */
		/**
		FinalDemoChild child = new FinalDemoChild();
		child.setDemoValue("def");
		System.out.println(child);
		***/ 
	}

}


final class FinalDemo{
	
	private String demoValue;
	
	public void setDemoValue(String demoValue){
		this.demoValue = demoValue;
	}
	
	public String getDemoValue(){
		return demoValue;
	}
	
	@Override
	public final String toString(){
		return getClass().getName() +  "[demoValue :"  + getDemoValue() +"]";
	}
	
}
/**
class FinalDemoChild extends FinalDemo{
	@Override
	public String toString(){
		return getClass().getName() + " extends net.frank.cheer.demo.ch11.FinalDemo"  +  "[demoValue :"  + getDemoValue() +"]";
	}
}
**/
