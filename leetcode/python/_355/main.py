from typing import List
from collections import defaultdict
from heapq import heappush, heappop

class Twitter:

    def __init__(self):
        self.timer = 0
        self.tweets = defaultdict(list)
        self.follows = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.timer += 1
        self.tweets[userId].append((self.timer, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        heaps = []
        feeds = []

        self.follows[userId].add(userId)
        for followeeId in self.follows[userId]:
            if not self.tweets[followeeId]: continue
            timer, tweetId = self.tweets[followeeId][-1]
            heappush(heaps, (-timer, tweetId, followeeId, len(self.tweets[followeeId]) - 1))
        while heaps and len(feeds) < 10:
            _, tweetId, uid, idx = heappop(heaps)
            feeds.append(tweetId)
            if idx - 1 >= 0:
                timer, tweetId = self.tweets[uid][idx - 1]
                heappush(heaps, (-timer, tweetId, uid, idx - 1))
        return feeds

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