public class Twitter {
    Map<Integer, User> userMap;
    Counter counter;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        counter = new Counter();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        createUserIfNotExist(userId);
        userMap.get(userId).tweets.add(new Tweet(tweetId, counter.getNextSerialNumber()));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        List<Tweet> tweets = new ArrayList<>();
        User user = userMap.get(userId);
        if (user == null) {
            return result;
        }
        addTweets(user, tweets);
        for (int friendId : user.friends) {
            User friend = userMap.get(friendId);
            if (friend != null) {
                addTweets(friend, tweets);
            }
        }
        Collections.sort(tweets, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return Long.compare(t1.timestamp, t2.timestamp);
            }
        });
        for (int i = tweets.size() - 1; i >= Math.max(0, tweets.size() - 10); i--) {
            result.add(tweets.get(i).id);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.friends.add(followee.id);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.friends.remove(followee.id);
    }
    
    private void createUserIfNotExist(int userId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
    }
    
    private void addTweets(User user, List<Tweet> tweets) {
        List<Tweet> list = user.tweets;
        for (int i = list.size() - 1; i >= Math.max(0, list.size() - 10); i--) {
            tweets.add(list.get(i));
        }
    }
}

class User {
    int id;
    Set<Integer> friends;
    List<Tweet> tweets;
    
    public User(int id) {
        this.id = id;
        this.friends = new HashSet<>();
        this.tweets = new ArrayList<>();
    }
}

class Tweet {
    int id;
    long timestamp;
    
    public Tweet(int id, long serialNumber) {
        this.id = id;
        this.timestamp = serialNumber;
    }
}

class Counter {
    private long serialNumber;
    
    public long getNextSerialNumber() {
        return serialNumber++;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
