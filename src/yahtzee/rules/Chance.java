package yahtzee.rules;

import java.util.ArrayList;

import yahtzee.Utility;

public class Chance implements YahtzeeRule {

	@Override
	public int calculate(ArrayList<Integer> dices) {
		return Utility.dicesTotal(dices);
	}

}
