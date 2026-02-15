from typing import List
from collections import defaultdict
from heapq import heappush, heappop

class Twitter:

    def __init__(self):
        self.tweets = defaultdict(deque)
        self.follows = defaultdict(set)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append((tweetId, self.time))
        self.time -= 1
        if len(self.tweets[userId]) > 10:
            self.tweets[userId].popleft()

    def getNewsFeed(self, userId: int) -> List[int]:
        userIds = self.follows[userId] | {userId}
        heap = []
        for uid in userIds:
            tweets = self.tweets[uid]
            if len(tweets) == 0: continue
            heappush(heap, (tweets[-1][1], len(tweets) - 1, tweets[-1][0], uid))
        res = []
        while heap and len(res) < 10:
            time, idx, tweetId, uid = heappop(heap)
            res.append(tweetId)
            if idx == 0: continue

            tweets = self.tweets[uid]
            heappush(heap, (tweets[idx-1][1], idx-1, tweets[idx-1][0], uid))
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