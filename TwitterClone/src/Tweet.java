//Richmond Akondo

public class Tweet {
	
	private String message = "";
	
	private long numOfLikes = 0;
	
	private long numOfRetweets = 0;
	
	public static final int MAX_LENGTH = 140;

	/**
	 * This constructor creates a tweet with the given message.
	 * If the message is null or its length is greater than 140,
	 * throw an IllegalArgumentException
	 * You will have to initialize other instance variables appropriately.
	 * 
	 * @param message the text of the tweet
	 */
	public Tweet(String message) {
		if(message == null || message.length() > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
		this.message = message;
		this.numOfLikes = 0;
		this.numOfRetweets = 0;
	}
	
	/**
	 * Copy constructor for the Tweet class. Notice that since the parameter 
	 * is already a Tweet, it was created by the Tweet() constructor, so it
	 * already contains valid text (i.e. old.text can never be invalid).
	 * This constructor is not tested directly, but it will help you write
	 * the deep copy constructor in TwitterUser.
	 * 
	 * @param old the Tweet object to be copied
	 */
	public Tweet(Tweet old) {
		this.message = old.message;
		this.numOfLikes = old.numOfLikes;
		this.numOfRetweets = old.numOfRetweets;
	}
	
	/**
	 * Makes appropriate changes in the instance variables to reflect that
	 * this tweet has been retweeted.
	 */
	public void retweet() {
		numOfRetweets++;
	}
	
	/**
	 * Makes appropriate changes in the instance variables to reflect that
	 * this tweet has been liked. 
	 */
	public void like() {
		numOfLikes++;
	}
	

	/**
	 * 
	 * @return the text of this tweet
	 */
	public String getText() {
		return message;
	}

	/**
	 * 
	 * @return the number of likes this tweet has received
	 */
	public long getNumLikes() {
		return numOfLikes;
	}

	/**
	 * 
	 * @return the number of times this tweet has been retweeted
	 */
	public long getNumRetweets() {
		return numOfRetweets;
	}
	

	/**
	 * Write the standard equals() method for the Tweet class.
	 * Two Tweets are equal if and only if their messages are equal.
	 * You should not check other instance variables.
	 */
	public boolean equals(Object other) {
		if(this == other)
			return true;
		if(!(other instanceof Tweet))
			return false;
		Tweet t1 = (Tweet)other;
		
		return this.message.equals(t1.message);
		
	}
}
