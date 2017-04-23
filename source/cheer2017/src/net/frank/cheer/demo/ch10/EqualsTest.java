<<<<<<< HEAD
package net.frank.cheer.demo.ch10;

public class EqualsTest {
	
	private Long longValue;
	private Integer intValue;
	private Character charValue;
	private Float floatValue;
	private Double doubleValue;
	
	public Long getLongValue(){
		return longValue;
	}
	
	public void setLongValue(Long longValue){
		this.longValue = longValue;
	}
	
	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}

	public Character getCharValue() {
		return charValue;
	}

	public void setCharValue(Character charValue) {
		this.charValue = charValue;
	}

	public Float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public boolean equals(EqualsTest obj) {
		if(null==null && obj == null ){
			return false;
		}else{
			if(checkSame(this.getLongValue(),obj.getLongValue())
					&& checkSame(this.getIntValue(),obj.getIntValue())
					&& checkSame(this.getCharValue(),obj.getCharValue())
					&& checkSame(this.getFloatValue(),obj.getFloatValue())
					&& checkSame(this.getDoubleValue(),obj.getDoubleValue())
					){
				return true;
			}else{
				return false;
			}
		}	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(getClass().getName()).append("[longValue =").append(longValue).
			append(",intValue =").append(intValue).
			append(",charValue =").append(charValue).
			append(",floatValue =").append(floatValue).
			append(",doubleValue =").append(doubleValue).
			append("]");
		return sb.toString();
	}
	
	
	private boolean checkSame(Object one,Object two){
		if(one==null && two == null){
			return true;
		}else if(one!=null && two == null){
			return false;
		}else if(one ==null && two !=null ){
			return false;
		}else{
			return one.equals(two);
		}
	}
	
	
	public static void main(String[] args) {
		EqualsTest test01 = new EqualsTest();
		EqualsTest test02 = new EqualsTest();
		//System.out.println(test01);
		//System.out.println(test02);
		/***
		if(test01 == test02){
			System.out.println("test01 == test02");
		}else {
			System.out.println("test01 != test02");
		}
		
		if(test01.equals(test02)){
			System.out.println("test01 equals test02 //to to");
		}else {
			System.out.println("test01 not equals test02");
		}
		**/
		
		equalsTest(test01,test02);
		test01.setLongValue(1L);
		equalsTest(test01,test02);
		test02.setLongValue(1L);
		equalsTest(test01,test02);
		test02.setLongValue(2L);
		equalsTest(test01,test02);
		
		test01.setIntValue(10);
		test02.setIntValue(20);
		equalsTest(test01,test02);
		
		test02.setIntValue(10);
		equalsTest(test01,test02);
		
		/***
		
		
		EqualsTest test03 = new EqualsTest();
		EqualsTest test04 = test03;
		System.out.println(test03);
		System.out.println(test04);
		if(test03 == test04){
			System.out.println("test03 == test04");
		}else {
			System.out.println("test03 != test04");
		}
		***/
		
	}
	
	private static void equalsTest(EqualsTest one, EqualsTest two){
		if(one.equals(two)){
			System.out.println("one equals two");
		}else{
			System.out.println("one not equals two");
		}
		System.out.println("one:" + one);
		System.out.println("two:" + two);
	}

}
=======
package net.frank.cheer.demo.ch10;

public class EqualsTest {
	
	private Long longValue;
	private Integer intValue;
	private Character charValue;
	private Float floatValue;
	private Double doubleValue;
	
	public Long getLongValue(){
		return longValue;
	}
	
	public void setLongValue(Long longValue){
		this.longValue = longValue;
	}
	
	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}

	public Character getCharValue() {
		return charValue;
	}

	public void setCharValue(Character charValue) {
		this.charValue = charValue;
	}

	public Float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public boolean equals(EqualsTest obj) {
		if(null==null && obj == null ){
			return false;
		}else{
			if(checkSame(this.getLongValue(),obj.getLongValue())
					&& checkSame(this.getIntValue(),obj.getIntValue())
					&& checkSame(this.getCharValue(),obj.getCharValue())
					&& checkSame(this.getFloatValue(),obj.getFloatValue())
					&& checkSame(this.getDoubleValue(),obj.getDoubleValue())
					){
				return true;
			}else{
				return false;
			}
		}	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(getClass().getName()).append("[longValue =").append(longValue).
			append(",intValue =").append(intValue).
			append(",charValue =").append(charValue).
			append(",floatValue =").append(floatValue).
			append(",doubleValue =").append(doubleValue).
			append("]");
		return sb.toString();
	}
	
	
	private boolean checkSame(Object one,Object two){
		if(one==null && two == null){
			return true;
		}else if(one!=null && two == null){
			return false;
		}else if(one ==null && two !=null ){
			return false;
		}else{
			return one.equals(two);
		}
	}
	
	
	public static void main(String[] args) {
		EqualsTest test01 = new EqualsTest();
		EqualsTest test02 = new EqualsTest();
		//System.out.println(test01);
		//System.out.println(test02);
		/***
		if(test01 == test02){
			System.out.println("test01 == test02");
		}else {
			System.out.println("test01 != test02");
		}
		
		if(test01.equals(test02)){
			System.out.println("test01 equals test02 //to to");
		}else {
			System.out.println("test01 not equals test02");
		}
		**/
		
		equalsTest(test01,test02);
		test01.setLongValue(1L);
		equalsTest(test01,test02);
		test02.setLongValue(1L);
		equalsTest(test01,test02);
		test02.setLongValue(2L);
		equalsTest(test01,test02);
		
		test01.setIntValue(10);
		test02.setIntValue(20);
		equalsTest(test01,test02);
		
		test02.setIntValue(10);
		equalsTest(test01,test02);
		
		/***
		
		
		EqualsTest test03 = new EqualsTest();
		EqualsTest test04 = test03;
		System.out.println(test03);
		System.out.println(test04);
		if(test03 == test04){
			System.out.println("test03 == test04");
		}else {
			System.out.println("test03 != test04");
		}
		***/
		
	}
	
	private static void equalsTest(EqualsTest one, EqualsTest two){
		if(one.equals(two)){
			System.out.println("one equals two");
		}else{
			System.out.println("one not equals two");
		}
		System.out.println("one:" + one);
		System.out.println("two:" + two);
	}

}
>>>>>>> 31b129c3f3c593a21cab3e593f97c9d640e54263
