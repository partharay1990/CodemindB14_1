package JavaPratices;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class CharacterCount {

	public static void main(String[] args) {

		String str = "parthasarathiray";
		int count = 0;

		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (tm.containsKey(str.charAt(i))) {

				count = tm.get(str.charAt(i));

				tm.put(str.charAt(i), count + 1);
			}

			else {

				tm.put(str.charAt(i), 1);
			}
		}

		// System.out.println(tm);

		Set<Entry<Character, Integer>> set = tm.entrySet();

		for (Entry<Character, Integer> ee : set) {

			System.out.println(ee.getKey() + " : " + ee.getValue());
		}

	}

}
