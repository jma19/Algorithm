package com.uci.mj;

import java.util.*;

public class Twitter {
    static int orderId = 0;

    class Twitte implements Comparable<Twitte> {
        int id;
        int pubId;
        int order;

        Twitte(int id, int pubId) {
            this.id = id;
            this.pubId = pubId;
            this.order = orderId;
            orderId++;
        }

        // order by time desc
        public int compareTo(Twitte o) {
            return this.order > o.order ? -1 : 1;
        }
    }

    private Map<Integer, Set<Integer>> followeeMap;
    private Map<Integer, List<Twitte>> followeerTwitteMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followeeMap = new HashMap();
        followeerTwitteMap = new HashMap();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Twitte tw = new Twitte(tweetId, userId);
        List<Twitte> tws = followeerTwitteMap.get(userId);
        if (tws == null) {
            tws = new ArrayList();
            followeerTwitteMap.put(userId, tws);
        }
        tws.add(tw);
        Set<Integer> followers = followeeMap.get(userId);
        if (followers == null) {
            followers = new HashSet<Integer>();
            followeeMap.put(userId, followers);
            return;
        }
        for (Integer id : followers) {
            tws = followeerTwitteMap.get(id);
            if (tws == null) {
                tws = new ArrayList();
                followeerTwitteMap.put(id, tws);
            }
            tws.add(tw);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Twitte> tws = followeerTwitteMap.get(userId);
        List<Integer> res = new ArrayList();
        if (tws == null) {
            return res;
        }
        Collections.sort(tws);
        for (int i = 0; i < 10 && i < tws.size(); i++) {
            res.add(tws.get(i).id);
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followeeMap.get(followeeId);
        if (followers == null) {
            followers = new HashSet();
            followeeMap.put(followeeId, followers);
        }
        followers.add(followerId);
        List<Twitte> tws = followeerTwitteMap.get(followerId);
        if (tws == null) {
            tws = new ArrayList();
            followeerTwitteMap.put(followerId, tws);
        }
        List<Twitte> tws1 = followeerTwitteMap.get(followeeId);
        if (tws1 == null) {
            tws1 = new ArrayList();
            followeerTwitteMap.put(followeeId, tws1);
        }
        for (int i = 0; i < tws1.size(); i++) {
            tws.add(tws1.get(i));
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followeeMap.get(followeeId);
        if (followers == null) {
            return;
        }
        followers.remove(Integer.valueOf(followerId));
        List<Twitte> tws = followeerTwitteMap.get(followerId);
        if (tws == null) {
            return;
        }
        List<Twitte> res = new ArrayList();
        for (Twitte t : tws) {
            if (t.pubId != followeeId) {
                res.add(t);
            }
        }
        followeerTwitteMap.put(followerId, res);
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