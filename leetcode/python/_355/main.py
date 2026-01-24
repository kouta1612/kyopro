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
            for timer, tweetId in self.tweets[uid]:
                heappush(heap, (timer, tweetId))
        res = []
        while heap and len(res) < 10:
            _, tweetId = heappop(heap)
            res.append(tweetId)
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