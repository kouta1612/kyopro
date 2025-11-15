from heapq import heappush, heappop

class MedianFinder:

    def __init__(self):
        self.maxHeap, self.minHeap = [], []

    def addNum(self, num: int) -> None:
        if not self.maxHeap or (self.maxHeap and -self.maxHeap[0] >= num): 
            heappush(self.maxHeap, -num)
        else: 
            heappush(self.minHeap, num)

        if len(self.maxHeap) == len(self.minHeap) + 2:
            heappush(self.minHeap, -heappop(self.maxHeap))
        elif len(self.maxHeap) + 2 == len(self.minHeap):
            heappush(self.maxHeap, -heappop(self.minHeap))

    def findMedian(self) -> float:
        if (len(self.maxHeap) + len(self.minHeap)) % 2 == 1:
            if len(self.maxHeap) > len(self.minHeap):
                return -self.maxHeap[0]
            else:
                return self.minHeap[0]
        return (-self.maxHeap[0] + self.minHeap[0]) / 2


medianFinder = MedianFinder()
medianFinder.addNum(1)
medianFinder.addNum(2)
print(medianFinder.findMedian())
medianFinder.addNum(3)
print(medianFinder.findMedian())