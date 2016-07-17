package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 7/17/2016.

 Design a simplified version of Twitter where users can post tweets,
 follow/unfollow another user and is able to see the 10 most recent
 tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.

 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 Each item in the news feed must be posted by users who the user followed or by the user herself.
 Tweets must be ordered from most recent to least recent.

 follow(followerId, followeeId): Follower follows a followee.

 unfollow(followerId, followeeId): Follower unfollows a followee.


 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);

 */
public class N355_DesignTwitter {
    // 195 ms
    // Design twitter.
    // Hashset for user-user relations
    // HashMap for user-tweets relations
    // HashMap for timestamp-tweets relations
    // PriorityQueue for sorting tweets by timestamp
    // use int as timestamp, only a temporary solution.
    public class Twitter {
        private int timestamp;
        Map<Integer, Set<Integer>> users;             // users includes relations
        Map<Integer, Map<Integer, Integer>> tweets;   // user's tweets with timestamp in map. Key is user.

        public Twitter() {
            timestamp = 0;
            users = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void createNewUserIfNotExist(int userId){
            if(!users.containsKey(userId)){
                users.put(userId, new HashSet<>());
                tweets.put(userId, new HashMap<>());
            }
        }

        public void postTweet(int userId, int tweetId) {
            createNewUserIfNotExist(userId);
            tweets.get(userId).put(timestamp++, tweetId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user
         * followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ret = new ArrayList<>();
            if(!users.containsKey(userId)) return ret;
            Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((e1,e2) -> e2.getKey() - e1.getKey());

            // add user's tweets
            for(Map.Entry<Integer, Integer> e: tweets.get(userId).entrySet()) maxHeap.add(e);

            // add the tweets of user followed
            for(Integer user: users.get(userId)){
                for(Map.Entry<Integer, Integer> e: tweets.get(user).entrySet()) maxHeap.add(e);
            }

            for(int i=0;i<10 && !maxHeap.isEmpty() ;i++){
                ret.add(maxHeap.remove().getValue());
            }
            return ret;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            createNewUserIfNotExist(followerId);
            createNewUserIfNotExist(followeeId);
            users.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            if(!users.containsKey(followeeId) || !users.containsKey(followerId)) return;
            users.get(followerId).remove(followeeId);
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


}
