import heapq

class MedianFinder:
    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -num)

        if self.small and self.large and -self.small[0] > self.large[0]:
            v = -heapq.heappop(self.small)
            heapq.heappush(self.large, v)

        if len(self.small) > len(self.large) + 1:
            v = -heapq.heappop(self.small)
            heapq.heappush(self.large, v)
        if len(self.large) > len(self.small) + 1:
            v = heapq.heappop(self.large)
            heapq.heappush(self.small, -v)

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return -self.small[0]
        if len(self.small) < len(self.large):
            return self.large[0]
        return (-self.small[0] + self.large[0]) / 2

medianFinder = MedianFinder()
medianFinder.addNum(1)
medianFinder.addNum(2)
print(medianFinder.findMedian())
medianFinder.addNum(3)
print(medianFinder.findMedian())