import java.util.ArrayList;
//Richmond Akondo

public class TwitterUser {
	
	private String userID = "";
	private ArrayList<Tweet> listOfTweets = new ArrayList<>();
	private long numFollowers = 0;
	private ArrayList<TwitterUser> listOfFollowing = new ArrayList<>();
	
	
	
	
	/**
	 * A constructor that takes the user's ID. If the ID is null, or
	 * longer than 32 characters, or it does not start with "@",
	 * throw an IllegalArgumentException.
	 * 
	 * All other instance variables should be initialized appropriately.
	 * 
	 * @param userID the ID of the new user
	 */

	
	public TwitterUser(String userID) {
		if(userID == null || userID.length() > 32 || userID.charAt(0) != '@') {
			throw new IllegalArgumentException();
		}
		this.userID = userID;
		this.listOfTweets = new ArrayList<>();
		this.numFollowers = 0;
		this.listOfFollowing = new ArrayList<>();
	}
	
	/**
	 * A pseudo copy-constructor that takes an existing user, a new userID,
	 * and a boolean flag. It should create a new user with the newID given 
	 * (which has the same restrictions as above), and the same tweets as the 
	 * old user that is being passed in. Information about the number of 
	 * followers or list of users the old user is following should NOT be copied.
	 * If the flag is false, make a shallow copy of the old user's tweet ArrayList, 
	 * otherwise make a deep copy. Never make a reference copy.
	 * All other instance variables should be initialized appropriately.
	 * It may help you to call the earlier constructor here.
	 * 
	 * @param old
	 * @param newID
	 */
	
	//uses addAll method for ArrayLists
	//addAll method is like a shallow copy for arraylists
	public TwitterUser(TwitterUser old, String newID, boolean flag) {
		this(newID);
		if(flag == false) {
			this.listOfTweets.addAll(old.listOfTweets);
		}
		else {
			for(int i = 0; i<old.listOfTweets.size(); i++) {
					Tweet t1 = new Tweet(old.listOfTweets.get(i));
					this.listOfTweets.add(t1);
			}
		}
		
	}
	
	
	/** 
	 * Creates a new Tweet object using the given message and adds it 
	 * to this user's list of tweets. 
	 * 
	 * Note: If the String passed in is null OR if the tweet is 
	 * longer than Tweet.MAX_LENGTH, then this method will not 
	 * add anything to the list and simply return false. 
	 * It will return true if it was able to add to the list.
	 * 
	 * @param message the message of the tweet
	 * @return true if the tweet was added to the list, false otherwise
	 */
	public boolean tweet(String message) {
		if(message == null || message.length() > Tweet.MAX_LENGTH) {
			return false;
		}
		else {
			Tweet t1 = new Tweet(message);
			this.listOfTweets.add(t1);
			return true;
		}

	}
	
	/**
	 * Adds all the tweets in the given list to this user's list.
	 * A 1-line solution exists (see ArrayList API).
	 * 
	 * @param tweets the list of tweets to be tweeted
	 * @return true if atleast one tweet was added, false otherwise
	 */
	
	//returns true if abke to add message to list of tweets
	///false if unable to add message
	public boolean tweetAll(ArrayList<Tweet> tweets) {
		return this.listOfTweets.addAll(tweets);
	}
	
	/**
	 * This method allows the user to retweet an already existing tweet.
 	 * You may have to make appropriate changes in the Tweet object.
 	 * Do not make a deep copy of the Tweet object, just point to it
 	 * directly.
	 * 
	 * @param t the Tweet Object to be retweeted
	 * @return true 
	 */
	
	//calls the retweet method from the Tweet class
	//adds the tweet object to the array of tweets
	public boolean retweet(Tweet t) {
		if(t == null) {
			return false;
		}
		else {
			t.retweet();
			listOfTweets.add(t);
			return true;
		}
	}
	
	
	/** 
	 * This method retweets all the tweets of the TwitterUser object
	 * that is passed in. Do not make a deep copy of the Tweets.
	 * 
	 * @param u the TwitterUser whose tweets are to be retweeted
	 * @return true 
	 */
	
	//loops through the users list of tweets and then
	//retweets all tweets 
	public boolean retweetAll(TwitterUser u) {
		for(int i = 0; i<u.listOfTweets.size(); i++) {
			if(retweet(u.listOfTweets.get(i)) == false) {
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * Like all the tweets of the TwitterUser that is passed in. It would
	 * be a good idea to look at the like() method of the Tweet class.
	 * There is no true/false return because a like is always successful.
	 * 
	 * @param u the TwitterUser whose tweets are to be liked
	 */
	
	//loops through the users list of tweets and
	//calls the like method from tweet class
	//to like the tweet
	public void likeAll(TwitterUser u) {
		for(int i = 0; i<u.listOfTweets.size(); i++) {
			u.listOfTweets.get(i).like();
		}
	}
	
	/**
	 * 
	 * @return the number of followers this user has
	 */
	public long getNumFollowers() {
		return numFollowers;
	}
	
	/**
	 * 
	 * @return the userID of this user
	 */
	public String getUsername() {
		return userID;
	}
	
	/**
	 * 
	 * @return the number of tweets this user has tweeted or retweeted
	 */
	public int getNumTweets() {
		return listOfTweets.size();
	}
	
	/**
	 * 
	 * @return the number of users this user follows
	 */
	public int getNumFollowing() {
		return listOfFollowing.size();
	}
	
	/**
	 * Given an index, return a reference to the Tweet object at that index in the array.
	 * Return null if the index is negative, or greater than or equal to
	 * the current number of tweets. 
	 * 
	 * NOTE: It is generally a terrible idea to give away reference copies,
	 * but we use this for testing.(See Lecture 36 privacy leak slides)
	 * 
	 * @param index the index of the desired tweet
	 * @return a reference copy of the tweet at index if index is valid, null otherwise
	 */
	
	//checks if index is valid, if not then it will return null
	//if the index is valid, it will get the index from the array
	public Tweet getTweet(int index) {
		if(index<0 || index>=listOfTweets.size()) {
			return null;
		}
		else {
			return listOfTweets.get(index);
		}
	}
	
	/**
	 * This method helps the current user follow the user that is passed 
	 * in. If  the TwitterUser passed in is not null and is not already 
	 * being followed by the current user, then add the given user to 
	 * this user's list. You may have to make appropriate changes to 
	 * this user's and/or the other user's instance variables. 
	 * This method will probably rely on the equals method you write.
	 * 
	 * @param u the user to be followed
	 * @return true if you were able to add u to this user's list, false otherwise
	 */
	
	//loops through the arraylist of following and
	//checks whether the current indes is equal to the
	//twitteruser. If it is, then don't add that user to list of 
	//following. If not, then add that user to list of following
	//and increase the number of followers for that user
	//this method works with the equals method
	public boolean follow(TwitterUser u) {
		if(u != null) {
			for(int i = 0; i<listOfFollowing.size(); i++) {
				if(listOfFollowing.get(i).equals(u)) {
					return false;
				}
			}
			listOfFollowing.add(u);
			u.numFollowers++;
			
		}
		return true;
	}
	
	/**
	 * This method helps the current user unfollow the given user.
	 * If the given user is being followed by the current user,
	 * remove them and return true. Otherwise, return false.
	 * You may have to modify instance variables as necessary.
	 * 
	 * @param u the user to be unfollowed
	 * @return true if you were able to unfollow, false otherwise
	 */
	
	//loops thorugh list of following and checks whether 
	//the user is in that list. If so, then remove user from that
	//list using the ".remove()" method.
	public boolean unfollow(TwitterUser u) {
		for(int i = 0; i<listOfFollowing.size(); i++) {
			if(!listOfFollowing.get(i).equals(u)) {
				return false;
			}
		}
		listOfFollowing.remove(u);
		u.numFollowers--;
		return true;
	}
	
	/**
	 * Checks if the user has tweeted or retweeted any tweet with the given message.
	 * Return false if the message is null or too long.
	 * @param message the message of the tweet to be searched
	 * @return true if the user has tweeted a tweet with the given message, false otherwise
	 */
	
	//creates tweet object with a message passed in if that message
	//is not null and if it is within the limit for number of tweet characters
	//checks if that object is in the arraylist
	public boolean hasTweeted(String message) {
		if(message != null || message.length() < Tweet.MAX_LENGTH) {
			Tweet t1 = new Tweet(message);
			for(int i = 0; i<listOfTweets.size(); i++) {
				if(listOfTweets.contains(t1)) {
					return true;
				}
			}
		}
		return false;
	
	}
	
	/**
	 * Removes ALL the tweets and retweets with the same message as the given message.
	 * Return false if the message is null or too long.
	 * 
	 * Hint: See removeAll() in the ArrayList API.
	 * 
	 * @param message the message of the tweet(s) to be removed
	 * @return true if atleast one tweet/retweet was removed, false otherwise
	 */
	
	//loops through the arraylist of tweets
	//checks if the current index is equal to a message that is not null
	//or within the character range
	public boolean delete(String message) {
		if(message == null || message.length() > Tweet.MAX_LENGTH) {	
			return false;
		}
		for(int i = 0; i<listOfTweets.size(); i++) {
			if(listOfTweets.get(i).getText().equals(message)) {
				this.listOfTweets.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Counts the number of tweets or retweets with the same message as the given message.
	 * Return -1 if the message is null.
	 * @param message the message of the tweets/retweets to be counted
	 * @return the count of the number of occurrences of this message
	 */
	
	//counts the number of times a given message occurs in
	//the arraylist
	public int count(String message) {
		int count = 0;
		if(message == null) {
			return -1;
		}
		for(int i = 0; i<listOfTweets.size(); i++) {
			if(listOfTweets.get(i).getText().equals(message))
			count++;
		}
		return count;
	}

	/**
	 * Checks if the Object passed in is logically equal to the current
	 * TwitterUser object. For the purpose of this project, two TwitterUsers
	 * are equal if they both have the same userID. You do not need to
	 * check for any other fields.
	 */
	public boolean equals(Object other) {
		if(this == other)
			return true;
		if(!(other instanceof TwitterUser))
			return false;
		TwitterUser t1 = (TwitterUser)other;
		
		return userID.equals(t1.userID);
	}
	
	
	/**
	 * Returns a shallow (NOT reference or deep) copy of the list of users
	 * that this user is following. A 1-line solution exists.
	 * Hint: One of the ArrayList constructors in its API.
	 * 
	 * @return a shallow copy of the users the current user is following
	 */
	
	public ArrayList<TwitterUser> getFollowing() {
		ArrayList<TwitterUser> newList = new ArrayList<TwitterUser>();
		newList.addAll(this.listOfFollowing);
		return newList;
	}
}
