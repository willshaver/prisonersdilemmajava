package a5;

import java.util.HashSet;
import java.util.Set;

/**
 * A single central registry of player ids. Use this class to ensure that player
 * ids are unique.
 */
public class IdRegistry {
	
	/**
	 * The set of unique ids known to the registry. 
	 */
	private static Set<String> IDS = new HashSet<>();
	
	private IdRegistry() {
		// private and empty by design.
		// Prevents the creation of IdRegistry objects which ensures that only
		// one set of ids will ever be created.
	}
	
	/**
	 * Register a player id with the central registry. Returns {@code true}
	 * if the specified id is available for use (is not currently used
	 * by another player), {@code false} otherwise.
	 * 
	 * <p>
	 * Successfully registering an id makes it unavailable for use by other players.
	 * 
	 * @param id an id
	 * @return true if the specified id is available for use, false otherwise
	 */
	public static boolean register(String id) {
		return IdRegistry.IDS.add(id);
	}
}
