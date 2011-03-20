package yahtzee.rules;

import java.util.ArrayList;

public class OneToSixRule implements YahtzeeRule {

	private int value;

	public OneToSixRule(int val) throws Exception {
		if (val < 1 || val > 6)
			throw new Exception(val + " is not a dice value!");
		this.value = val;
	}

	public int calculate(ArrayList<Integer> dices) {
		int score = 0;
		for (Integer dice : dices) {
			if (dice.intValue() == value) {
				score += value;
			}
		}
		return score;
	}

}
