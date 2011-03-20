package yahtzee.rules;

import java.util.ArrayList;
import java.util.Collections;

import yahtzee.Utility;

public class FullHouse implements YahtzeeRule {

	@Override
	public int calculate(ArrayList<Integer> dices) {
		ArrayList<Integer> uniqueDicesList = Utility
				.removeDuplicatesAndOrder(dices);
		
		if(uniqueDicesList.size() == 2 
				&& Collections.frequency(dices, uniqueDicesList.get(0)) >= 2
				&& Collections.frequency(dices, uniqueDicesList.get(1)) >= 2)
			return 25;
		return 0;
	}
}
