package a5;

/**
 * A player in the iterated prisoner's dilemma game. A player has a unique id so
 * that they can be distinguished from other players. A player has an integer
 * amount of money that they can gamble with.
 */
public interface Player {

	/**
	 * Returns the unique id of this player.
	 * 
	 * @return the unique id of this player
	 */
	
	public String id();
	

	/**
	 * Gets this player's action when playing against another player having the
	 * specified id. A player cannot respond to itself.
	 * 
	 * @param otherPlayerId the id of the other player
	 * @return the action that this player chooses
	 * @throws IllegalArgumentException if the other player id is equal to this
	 *                                  player's id
	 */
	public Action respondTo(String otherPlayerId);

	/**
	 * Remembers the action taken by another player for the most recent round of the
	 * prisoner's dilemma game.
	 * 
	 * @param otherPlayerId the id of the other player
	 * @param a             the action that the other player chose
	 */
	public void remember(String otherPlayerId, Action a);

	/**
	 * The amount of money that this player currently has.
	 * 
	 * @return amount of money that this player currently has
	 */
	public int balance();

	/**
	 * Increases the balance of this player by the specified amount.
	 * 
	 * @param dollars a number of dollars
	 * @throws IllegalArgumentException if dollars is less than 0
	 */
	public void win(int dollars);

	/**
	 * Decreases the balance of this player by the specified amount.
	 * 
	 * @param dollars a number of dollars
	 * @throws IllegalArgumentException if dollars is less than 0
	 */
	public void lose(int dollars);

}
