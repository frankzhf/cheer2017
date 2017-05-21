package net.frank.cheer.demo.ch14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayLinkedListTest {
	public static void main(String[] args){
		int [] array = new int[]{
			1,2,3,4,5,6,7,8,9,10
		};
		System.out.println(array[4]);
		
		
		/***
		for(int i=10;i>=1;i++){
			Linked linked = new Linked();
			linked.setValue(i);
			linked.setNext(next);
			next = linked;
		}
		***/
		
		
		int i= 1;
		Linked prev = new Linked();
		prev.setValue(1);
		Linked first = prev;
		i++;
		while(i<=10){
			Linked obj = new Linked();
			obj.setValue(i);
			prev.setNext(obj);
			i++;
			prev = obj;
		}	
		//first = first.getNext();
		System.out.println(first);
		
		
		
		//List<Integer> intList = new ArrayList<Integer>();
		
		List intList0 = new ArrayList();
		
		intList0.add(1);
		intList0.add(2);
		intList0.add(3);
		System.out.println(intList0.size());
		intList0.add(4);
		System.out.println(intList0.size());
		
		List intList1 = new LinkedList();
		
		intList1.add(1);
		intList1.add(2);
		intList1.add(3);
		System.out.println(intList1.size());
		intList1.add(4);
		System.out.println(intList1.size());
		
		
		
		
		
	}
	
	
	
}


class Linked{
	private int value;
	private Linked next;
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}

	public Linked getNext() {
		return next;
	}

	public void setNext(Linked next) {
		this.next = next;
	}
	
	
	
}