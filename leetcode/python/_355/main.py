from typing import List
from collections import defaultdict
from heapq import heappush, heappop

class Twitter:

    def __init__(self):
        self.timer = 0
        self.tweets = defaultdict(list)
        self.follows = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append((self.timer, tweetId))
        self.timer -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        userIds = [userId] + list(self.follows[userId])
        heap = []
        for uid in userIds:
            if self.tweets[uid]:
                timer, tweetId = self.tweets[uid][-1]
                heappush(heap, (timer, tweetId, uid, len(self.tweets[uid])-1))
        res = []
        while heap and len(res) < 10:
            timer, tweetId, uid, idx = heappop(heap)
            res.append(tweetId)
            if idx > 0:
                next_timer, next_tweetId = self.tweets[uid][idx-1]
                heappush(heap, (next_timer, next_tweetId, uid, idx-1))
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: return
        self.follows[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId not in self.follows[followerId]: return
        self.follows[followerId].remove(followeeId)

print(Twitter().postTweet(1, 5))
print(Twitter().getNewsFeed(1))
print(Twitter().follow(1, 2))
print(Twitter().postTweet(2, 6))
print(Twitter().getNewsFeed(1))
print(Twitter().unfollow(1, 2))
print(Twitter().getNewsFeed(1))