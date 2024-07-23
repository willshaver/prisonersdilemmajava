package a5;

import java.util.HashMap;

/**
 * Simulates a tournament of the iterated prisoner's dilemma using players
 * of each type. 
 */
public class Tournament {

	/**
	 * The amount that a player wins when both players choose to cooperate.
	 */
	public static final int WINNINGS_MUTUAL_COOPERATION = 0;

	/**
	 * The amount that a player wins by betraying an opponent that chose to
	 * cooperate.
	 */
	public static final int WINNINGS_BETRAYAL = 8;

	/**
	 * The amount that a player loses when both players betray each other.
	 */
	public static final int LOSS_MUTUAL_BETRAYAL = 10;

	/**
	 * The amount that a player loses by cooperating with an opponent that chose
	 * betrayal.
	 */
	public static final int LOSS_COOPERATION = 20;

	
	
	/**
	 * Plays one game of the prisoner's dilemma. A player cannot play against
	 * itself.
	 * 
	 * @param p1 a player
	 * @param p2 a player
	 * @throws IllegalArgumentException if p1 == p2 is true
	 */
	public static void play(Player p1, Player p2) {
		// 1. get p1's choice of action against p2
	    // 2. get p2's choice of action against p1
	    // 3. determine how much p1 wins or loses and inform p1
	    // 4. determine how much p2 wins or loses and inform p2
	    // 5. inform p1 of p2's action (so that p1 can remember p2's action)
	    // 5. inform p2 of p1's action (so that p2 can remember p1's action)
		if (p1 == p2) {
            throw new IllegalArgumentException("players are equal");
        }
		Action p1Action = p1.respondTo(p2.id());
		Action p2Action = p2.respondTo(p1.id());
		
		if (p1Action == p2Action && p1Action == Action.COOPERATE) {
			p1.win(WINNINGS_MUTUAL_COOPERATION);
			p2.win(WINNINGS_MUTUAL_COOPERATION);
		}
		else if (p1Action != p2Action && p1Action == Action.COOPERATE) {
			p1.lose(LOSS_COOPERATION);
			p2.win(WINNINGS_BETRAYAL);
		}
		else if (p1Action != p2Action && p2Action == Action.COOPERATE) {
			p1.win(WINNINGS_BETRAYAL);
			p2.lose(LOSS_COOPERATION);
		}
		else {
			p2.lose(LOSS_MUTUAL_BETRAYAL);
			p1.lose(LOSS_MUTUAL_BETRAYAL);
		}
		
		p1.remember(p2.id(),p2Action);
		p2.remember(p1.id(), p1Action);
		
		
		
       
		
		
		
	}

	/**
	 * Repeatedly plays multiple rounds of the prisoner's dilemma game between two
	 * players. The player ids and final player balances are printed after all
	 * rounds have been played.
	 * 
	 * @param p1        a player
	 * @param p2        a player
	 * @param numRounds the number of rounds to play
	 * @throws IllegalArgumentException if the number of rounds is negative
	 */
	public static void play(Player p1, Player p2, int numRounds) {
		if (numRounds < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < numRounds; i++) {
			play(p1, p2);
		}
		System.out.println(p1.id() + " vs. " + p2.id());
		System.out.println(p1.balance() + " " + p2.balance());
		System.out.println();
	}

	/**
	 * Simulates a tournament where a player of each type (naive, aggressive,
	 * tit-for-tat) plays against players of all other types. Players play against
	 * other players for 1000 rounds. The final balance for one player of each type
	 * is printed.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Player p1 = new NaivePlayer("NAIVE1", 20000);
		Player p2 = new NaivePlayer("NAIVE2", 20000);

		Player p3 = new AggressivePlayer("AGGRO1", 20000);
		Player p4 = new AggressivePlayer("AGGRO2", 20000);

		Player p5 = new TitForTatPlayer("TFORT1", 20000);
		Player p6 = new TitForTatPlayer("TFORT2", 20000);

		// naive player versus all other types of players
		play(p2, p1, 1000);
		play(p2, p3, 1000);
		play(p2, p5, 1000);

		// aggressive player versus all other types of players
		play(p4, p1, 1000);
		play(p4, p3, 1000);
		play(p4, p5, 1000);

		// tit-for-tat player versus all other types of players
		play(p6, p1, 1000);
		play(p6, p3, 1000);
		play(p6, p5, 1000);
		
		
		System.out.println(p2.id() + " balance : " + p2.balance());
		System.out.println(p4.id() + " balance : " + p4.balance());
		System.out.println(p6.id() + " balance : " + p6.balance());
	}

}
