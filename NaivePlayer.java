package a5;
import java.util.HashMap;
/**
 * A naive player in the prisoner's dilemma game. A naive player always chooses
 * to cooperate with the other player.
 * 
 * <p>
 * A naive player has no memory of past games with other players.
 */
public class NaivePlayer implements Player {


	public String playerId = null;
	public int playerBalance = 0;
	public HashMap<String, Action> playerMoves = new HashMap<>();
	
	/**
	 * Initializes a player having the specified id and balance in dollars.
	 * 
	 * @param id      the id of this player
	 * @param balance the balance in dollars for this player
	 * @throws IllegalArgumentException if the id is already in use by another
	 *                                  player
	 * @throws IllegalArgumentException if the balance is less than or equal to zero
	 */
	public NaivePlayer(String id, int balance) {
		playerId = id;
		playerBalance = balance;
		
		if (playerBalance <= 0)
			throw new IllegalArgumentException("this balance is invalid");
		if (!IdRegistry.register(playerId))
			throw new IllegalArgumentException("this id is invalid");
	}
	
	
	@Override
	public String id() {
		return playerId;
	}
	
	@Override
	public String toString() {
		return playerId;
	}

	@Override
	public Action respondTo(String otherPlayerId) {
		if (this.equals(otherPlayerId)) {
			throw new IllegalArgumentException("two player ids are the same");
		}
		return Action.COOPERATE;

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
