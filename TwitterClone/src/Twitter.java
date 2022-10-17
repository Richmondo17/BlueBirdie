import java.util.ArrayList;
//Richmond Akondo
 class Twitter {
	
	/**
	 * The only instance of Twitter to exist.
	 */
	public static final Twitter ONLY_INSTANCE = new Twitter();

	private ArrayList<TwitterUser> users;
	
	/**
	 * Private constructor so that no one can create Twitter objects.
	 */
	private Twitter() {
		users = new ArrayList<TwitterUser>();
	}
	
	/**
	 * Creates a new user with the given username and adds to the list of users.
	 * Return false if the username is null, too long, does not start with '@',
	 * or a user with this username already exists.
	 * 
	 * @param userID the username of the new user
	 * @return true if the user could be created and added, false otherwise
	 */
	public boolean signUp(String userID) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Removes the user from the list if such a user exists. Return false if u is null.
	 * Removing a user means that all the users that the removed user followed will lose a follower.
	 * However, the tweets that this user liked or retweeted will NOT lose their count of likes/retweets.
	 * 
	 * @param userID the username of the user to be deleted
	 * @return true if the user could be deleted, false otherwise
	 */
	public boolean deactivate(TwitterUser u) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Resets Twitter to having 0 users.
	 */
	public void reset() {
		users.clear();
	}
}
