package net.frank.cheer.demo.ch03;

public class PlusPlus {

	public static void main(String[] args) {

		int success = 60;
		int mySorce = 70;
		if (mySorce > success) 
		{

		} 
		else 
		{

		}

		String[] array = new String[] { "aa", "bb", "cc" };

		{
			int kk = 1;
			kk++;
			System.out.println(kk);
		}

		for (int i = 0; i < array.length;) {
			String value = array[i++];
			// String value = array[i]
			// i = i+1

			// String value = array[++i];
			// i = i+1
			// String value = array[i]

			System.out.println(i);
			System.out.println(value);
		}
	}

}
