package yahtzee.rules;

import java.util.ArrayList;
import java.util.Collections;

import yahtzee.Utility;

public class OfAKind implements YahtzeeRule {

	
	private int number;

	/**
	 * Instantiate a new object
	 * @param nr the length of the sequence
	 * @throws Exception if <code>nr</code> is less than 4 or greater than 5
	 */
	public OfAKind(int nr) throws Exception {
		if (nr > 4 || nr < 3)
			throw new Exception(nr
					+ " is not valid: this rule accept only 3 or 4 as value.");
		this.number = nr;
	}
	
	@Override
	public int calculate(ArrayList<Integer> dices) {
		ArrayList<Integer> uniqueDicesList = Utility.removeDuplicatesAndOrder(dices);
		for (Integer dice : uniqueDicesList) {
			if(Collections.frequency(dices, dice) == this.number)
				return Utility.dicesTotal(dices);
		}
		return 0;
	}

}
