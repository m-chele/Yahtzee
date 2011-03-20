package yahtzee.rules;

import java.util.ArrayList;

import yahtzee.Utility;

public class Yahtzee implements YahtzeeRule {

	
	private int previousYahtzee;
	
	public Yahtzee(int previousYahtzee) {
		this.previousYahtzee = previousYahtzee;
	}
	
	@Override
	public int calculate(ArrayList<Integer> dices) {
		ArrayList<Integer> uniqueDicesList = Utility.removeDuplicatesAndOrder(dices);
		if (uniqueDicesList.size() != 1) return 0;
		return previousYahtzee < 1 ? 50 : 100;
	}

}
