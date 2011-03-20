package yahtzee.rules;

import java.util.ArrayList;

public interface YahtzeeRule {

	/**
	 * Calculate the score of the dices based on the 
	 * rule object that executes the method 
	 * @return int representing the score
	 */
	public int calculate(ArrayList<Integer> dices);

}
