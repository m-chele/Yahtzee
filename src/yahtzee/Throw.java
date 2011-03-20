package yahtzee;

import java.util.ArrayList;

import yahtzee.rules.YahtzeeRule;

public class Throw {

	private ArrayList<Integer> dices;
	
	public Throw(Integer[] dices) {
		this.dices = new ArrayList<Integer>();
		for (Integer dice : dices) {
			this.dices.add(dice);
		}
	}

	public int score(YahtzeeRule rule) {
		return rule.calculate(this.dices);
	}
	
}
