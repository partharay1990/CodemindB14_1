package JavaPratices;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(943716, "Happy");
		hm.put(943717, "Lucky");
		hm.put(943718, "Pinky");
		hm.put(943719, "Suchi");
		hm.put(943720, "Happy");

		Set<Entry<Integer, String>> es = hm.entrySet();

		Iterator<Entry<Integer, String>> it = es.iterator();

		while (it.hasNext()) {

			Entry<Integer, String> nex = it.next();

			System.out.println(nex.getKey() + " : " + nex.getValue());
		}

		System.out.println("######################################");

		for (Entry<Integer, String> fr : es) {

			System.out.println(fr.getKey() + " : " + fr.getValue());

		}
		
		System.out.println("######################################");
		
		Set<Integer> keyset = hm.keySet();

		for (Integer i : keyset) {

			System.out.println(i);
		}
		
		System.out.println("######################################");

	}

}
