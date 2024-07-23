package a5;

import java.util.HashMap;
import java.util.Map;

/**
 * A player that uses the tit-for-tat strategy in the prisoner's dilemma game.
 * 
 * <p>
 * A {@code TitForTatPlayer} remembers the last action taken by each player it
 * has encountered. A player using the tit-for-tat strategy always cooperates
 * with a player it has never encountered before. When playing against a player
 * that has been encountered before, this player chooses the action that the
 * other player chose in their previous encounter; i.e., this player cooperates
 * if the other player previously cooperated with this player, and this player
 * betrays if the other player previously betrayed this player.
 * 
 * <p>
 * The memory of this player cannot be manipulated by other objects.
 * 
 */
public class TitForTatPlayer implements Player {

	
	public String playerId = null;
	public int playerBalance = 0;
	public HashMap<String, Action> playerMoves = new HashMap<>();
	
	
	

	/**
	 * Initializes a player having the specified id and balance in dollars. The
	 * player has no current memory of interactions with other players.
	 * 
	 * @param id      the id of this player
	 * @param balance the balance in dollars for this player
	 * @throws IllegalArgumentException if the id is already in use by another
	 *                                  player
	 * @throws IllegalArgumentException if the balance is less than or equal to zero
	 */
	public TitForTatPlayer(String id, int balance) {
		playerId = id;
		playerBalance = balance;
		
		if (playerBalance <= 0)
			throw new IllegalArgumentException("this balance is invalid");
		if (!IdRegistry.register(playerId))
			throw new IllegalArgumentException("this id is invalid");
	}

	/**
	 * Returns a map of the most recent past interactions with other players that
	 * this player has competed against.
	 * 
	 * <p>
	 * The returned map can be modified without affecting the memory of this player.
	 * 
	 * @return a map of the most recent past interactions with other players that
	 *         this player has competed against
	 */
	public Map<String, Action> getMemory() {
		return playerMoves;
	}
	

	
	@Override
	public String id() {
		return playerId;
	}

	@Override
	public Action respondTo(String otherPlayerId) {
		if (this.equals(otherPlayerId)) {
			throw new IllegalArgumentException("two player ids are the same");
		}
		if (!playerMoves.containsKey(otherPlayerId)) {
			return Action.COOPERATE;}
		
		else if (playerMoves.get(otherPlayerId) == Action.COOPERATE) {
			return Action.COOPERATE;}
		
		else {
			return Action.BETRAY;}
	}

	@Override
	public void remember(String otherPlayerId, Action a) {
		if (playerMoves.containsKey(otherPlayerId)) {
			playerMoves.put(otherPlayerId, a);}
		else if (!playerMoves.containsKey(otherPlayerId)) {
			playerMoves.put(otherPlayerId, a);}
	}

	@Override
	public int balance() {
		return playerBalance;
	}

	@Override
	public void win(int dollars) {
		playerBalance += dollars;
		
	}

	@Override
	public void lose(int dollars) {
		playerBalance -= dollars;
		
	}

	
	
	

}
