package yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Utility {

	/**
	 * Removes the duplicates and order the value from min to max.
	 * @param dices
	 * @return
	 */
	public static ArrayList<Integer> removeDuplicatesAndOrder(ArrayList<Integer> dices) {
		HashSet<Integer> uniqueDicesHash = new HashSet<Integer>(dices);
		ArrayList<Integer> uniqueDicesList = new ArrayList<Integer>(
				uniqueDicesHash);
		Collections.sort(uniqueDicesList);
		return uniqueDicesList;
	}

	/**
	 * Calculate the sum of all the dices specified as argument 
	 * @param dices
	 * @return
	 */
	public static int dicesTotal(ArrayList<Integer> dices) {
		int total = 0;
		for (Integer dice : dices) {
			total += dice;
		}
		return total;
	}
	
}
