package yahtzee.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import yahtzee.Throw;
import yahtzee.rules.Chance;
import yahtzee.rules.FullHouse;
import yahtzee.rules.OfAKind;
import yahtzee.rules.OneToSixRule;
import yahtzee.rules.SequenceOf;
import yahtzee.rules.Yahtzee;
import yahtzee.rules.YahtzeeRule;

public class ThrowTest {

	/* ACES TO SIXIES RULE */
	/* ********************************************************************* */
	@Test
	public void aces_rule_with_no_1_is_0() throws Exception {
		assertScoreIs(0, new Integer[] { 2, 2, 2, 2, 2 }, new OneToSixRule(1));
	}

	@Test
	public void aces_rule_with_one_1_is_1() throws Exception {
		assertScoreIs(1, new Integer[] { 2, 2, 2, 1, 2 }, new OneToSixRule(1));
	}

	@Test
	public void fourties_rule_with_one_4_is_4() throws Exception {
		assertScoreIs(4, new Integer[] { 2, 2, 4, 1, 2 }, new OneToSixRule(4));
	}

	@Test
	public void fourties_rule_with_three_4_is_12() throws Exception {
		assertScoreIs(12, new Integer[] { 4, 2, 4, 1, 4 }, new OneToSixRule(4));
	}

	@Test
	public void sixes_rule_with_no_6_is_0() throws Exception {
		assertScoreIs(0, new Integer[] { 2, 2, 2, 1, 2 }, new OneToSixRule(6));
	}

	@Test
	public void sixes_rule_with_one_6_is_6() throws Exception {
		assertScoreIs(6, new Integer[] { 2, 2, 6, 1, 2 }, new OneToSixRule(6));
	}

	/* SEQUENCE OF FOUR/FIVE RULE */
	/* ********************************************************************* */
	@Test
	public void sequence_of_4_rule_is_30() throws Exception {
		assertScoreIs(30, new Integer[] { 1, 2, 3, 4, 2 }, new SequenceOf(4));
	}
	
	@Test
	public void sequence_of_4_rule_is_30_also_if_5_checks() throws Exception {
		assertScoreIs(30, new Integer[] { 1, 2, 3, 4, 5 }, new SequenceOf(4));
	}
	
	@Test
	public void sequence_of_4_can_start_at_second_dice() throws Exception {
		assertScoreIs(30, new Integer[] { 1, 3, 4, 5, 6 }, new SequenceOf(4));
	}
	
	@Test
	public void sequence_of_4_can_start_with_2() throws Exception {
		assertScoreIs(30, new Integer[] { 3, 5, 4, 6, 2 }, new SequenceOf(4));
	}
	
	@Test
	public void sequence_of_4_rule_is_0_if_not_consecutives() throws Exception {
		assertScoreIs(0, new Integer[] { 1, 2, 4, 5, 6 }, new SequenceOf(4));
	}
	
	@Test
	public void sequence_of_5_rule_is_40() throws Exception {
		assertScoreIs(40, new Integer[] { 1, 2, 3, 4, 5 }, new SequenceOf(5));
	}
	
	@Test
	public void sequence_of_5_rule_is_40_2() throws Exception {
		assertScoreIs(40, new Integer[] { 3, 2, 5, 6, 4 }, new SequenceOf(5));
	}
	
	@Test
	public void sequence_of_5_rule_is_0_for_duplicates() throws Exception {
		assertScoreIs(0, new Integer[] { 1, 1, 2, 4, 3 }, new SequenceOf(5));
	}
		
	@Test
	public void sequence_rule_doesn_t_depend_by_dices_order() throws Exception {
		assertScoreIs(40, new Integer[] { 1, 4, 3, 2, 5 }, new SequenceOf(5));
		assertScoreIs(0, new Integer[] { 1, 2, 3, 2, 5 }, new SequenceOf(5));
	}
	
	/* 3/4 OF A KIND */
	/* ********************************************************************* */
	@Test
	public void three_of_a_kind_is_the_sum_of_all_dices() throws Exception {
		assertScoreIs(14, new Integer[] { 2, 2, 3, 2, 5 }, new OfAKind(3));
	}
	
	@Test
	public void three_of_a_kind_is_not_verified() throws Exception {
		assertScoreIs(0, new Integer[] { 2, 3, 3, 2, 5 }, new OfAKind(3));
	}
	
	@Test
	public void four_of_a_kind_is_the_sum_of_all_dices() throws Exception {
		assertScoreIs(11, new Integer[] { 2, 2, 3, 2, 2 }, new OfAKind(4));
	}
	
	@Test
	public void four_of_a_kind_is_not_verified() throws Exception {
		assertScoreIs(0, new Integer[] { 2, 3, 3, 3, 5 }, new OfAKind(4));
	}
	
	/* FULL HOUSE */
	/* ********************************************************************* */
	@Test
	public void full_is_25() throws Exception {
		assertScoreIs(25, new Integer[] { 2, 3, 3, 3, 2 }, new FullHouse());
	}
	
	@Test
	public void full_is_not_verified() throws Exception {
		assertScoreIs(0, new Integer[] { 3, 3, 3, 3, 2 }, new FullHouse());
	}
	
	/* YAHTZEE */
	/* ********************************************************************* */
	@Test
	public void first_yahtzee_is_50() throws Exception {
		assertScoreIs(50, new Integer[] { 3, 3, 3, 3, 3 }, new Yahtzee(0));
	}
	
	@Test
	public void second_yahtzee_is_100() throws Exception {
		assertScoreIs(100, new Integer[] { 3, 3, 3, 3, 3 }, new Yahtzee(1));
	}
	
	@Test
	public void yahtzee_is_not_verified() throws Exception {
		assertScoreIs(0, new Integer[] { 3, 4, 4, 4, 4 }, new Yahtzee(1));
	}
	/* CHANCE */
	/* ********************************************************************* */
	@Test
	public void chance_poin_is_the_sum_of_dices() throws Exception {
		assertScoreIs(14, new Integer[] { 3, 3, 3, 3, 2 }, new Chance());
	}
	
	/* PRIVATE METHODS */
	
	private void assertScoreIs(int scoreExpected, Integer[] dices,
			YahtzeeRule rule) throws Exception {

		Throw yThrow = new Throw(dices);
		assertEquals(scoreExpected, yThrow.score(rule));
	}

}
