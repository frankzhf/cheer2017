package net.frank.cheer.demo.ch14;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Country china = new Country();
		china.setTitle("Republic of China");
		china.setName("China");
		china.setCode("cn");
		
		
		Country unionStatus = new Country();
		unionStatus.setTitle("Union Status");
		unionStatus.setName("Amerina");
		unionStatus.setCode("us");
		
		Map g2 = new HashMap();
		g2.put(china.getCode(), china);
		g2.put(unionStatus.getCode(), unionStatus);
		
		
		System.out.println(g2.get("cn"));
		System.out.println(g2.get("us"));
		
		
		Country [] array = new Country[100]; // 0 --99
		
		System.out.println(china.getCode().hashCode());
		System.out.println(unionStatus.getCode().hashCode());
		
		int index = china.getCode().hashCode()% array.length;
		array[index] = china;
		
		
		
		
	}

}

class Country{
	private String title;
	private String name;
	private String code;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Country [title=" + title + ", name=" + name + ", code=" + code + "]";
	}
}