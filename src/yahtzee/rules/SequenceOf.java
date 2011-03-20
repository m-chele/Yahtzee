package yahtzee.rules;

import java.util.ArrayList;
import java.util.List;

import yahtzee.Utility;

public class SequenceOf implements YahtzeeRule {

	private int number;

	/**
	 * Instantiate a new object
	 * @param nr the length of the sequence
	 * @throws Exception if <code>nr</code> is less than 4 or greater than 5
	 */
	public SequenceOf(int nr) throws Exception {
		if (nr > 5 || nr < 4)
			throw new Exception(nr
					+ " is not valid: this rule accept only 4 or 5 as value.");
		this.number = nr;
	}


	@Override
	public int calculate(ArrayList<Integer> dices) {
		ArrayList<Integer> uniqueDicesList = Utility.removeDuplicatesAndOrder(dices);
		boolean isSequence = this.isSequence(uniqueDicesList);
		if (isSequence && number == 4)
			return 30;
		if (isSequence && number == 5)
			return 40;
		return 0;
	}

	/**
	 * Indicates the number of dices to skip at each recursion
	 */
	private int skip = 1;

	/**
	 * Indicates if the elements of specified list are a
	 * sequence of number. The length of the checked sequence is
	 * the argument passed as parameter of the constructor.
	 * @param orderedDices
	 * @return
	 */
	private boolean isSequence(List<Integer> orderedDices) {
		if (orderedDices.size() < this.number)
			return false;
		boolean isGreater = true;
		for (int i = 0; i < (orderedDices.size() - 1); i++) {
			isGreater = isGreater
					&& (orderedDices.get(i) == orderedDices.get(i + 1) - 1);
		}
		return isGreater ? isGreater : isSequence(orderedDices.subList(skip++,
				orderedDices.size()));
	}

}
