package JavaPratices;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMethods {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(10);
		al.add(100);
		al.add(50);
		al.add(70);

		for (Integer i : al) {

			System.out.println(i);
		}

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		Iterator<Integer> it = al.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

		System.out.println("1st index value = " + al.get(1));

		System.out.println("size of this list = " + al.size());

	}

}
