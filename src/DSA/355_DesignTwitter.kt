package DSA

import java.util.PriorityQueue

class DesignTwitter {
    data class User(val userId: Int) {
        val tweets = ArrayDeque<Pair<Int, Int>>()
        val following = mutableSetOf<Int>()
        val newsfeed = PriorityQueue<Pair<Int, Int>> { t1, t2 -> t2.second - t1.second }
        val followers = mutableSetOf<Int>()
    }

    val users = mutableMapOf<Int, User>()
    var count = 0

    fun postTweet(userId: Int, tweetId: Int) {
        count++
        val tweet = Pair(tweetId, count)
        if (userId in users) {
            val user = users[userId]!!
            user.tweets.add(tweet)
            user.newsfeed.add(tweet)
//            if (user.tweets.size > 10) {
//                user.tweets.removeFirst()
//            }
            for (followerId in user.followers) {
                if (followerId in users) {
                    val follower = users[followerId]!!
                    follower.newsfeed.add(tweet)
                } else {
                    val follower = User(followerId)
                    follower.newsfeed.add(tweet)
                    users[followerId] = follower
                }
            }
        } else {
            val user = User(userId)
            user.tweets.add(tweet)
            user.newsfeed.add(tweet)
            users[userId] = user
        }
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feed = mutableListOf<Int>()
        if (userId in users) {
            val user = users[userId]!!
            val stack = ArrayDeque<Pair<Int, Int>>()
            while (user.newsfeed.isNotEmpty()) {
                val tweet = user.newsfeed.poll()
                stack.add(tweet)
                feed.add(tweet.first)
                if (feed.size == 10) {
                    break
                }
            }
            while (stack.isNotEmpty()) {
                user.newsfeed.add(stack.removeFirst())
            }
        }
        return feed
    }

    fun follow(followerId: Int, followeeId: Int) {
        val follower = users.getOrPut(followerId) { User(followerId) }
        val followee = users.getOrPut(followeeId) { User(followeeId) }
        if (followeeId in follower.following) {
            return
        }
        followee.followers.add(follower.userId)
        follower.following.add(followee.userId)
        followee.tweets.forEach {
            follower.newsfeed.add(it)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val follower = users.getOrPut(followerId) { User(followerId) }
        val followee = users.getOrPut(followeeId) { User(followeeId) }
        if (followeeId !in follower.following) {
            return
        }
        followee.followers.remove(followerId)
        follower.following.remove(followeeId)
        followee.tweets.forEach {
            follower.newsfeed.remove(it)
        }
    }
}