import heapq
from typing import List

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k, self.minHeap = k, nums
        heapq.heapify(self.minHeap)
        while len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)

    def add(self, val: int) -> int:
        heapq.heappush(self.minHeap, val)
        while len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)
        return self.minHeap[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

print(KthLargest(3, [4, 5, 8, 2]).add(3))
print(KthLargest(3, [4, 5, 8, 2]).add(5))
print(KthLargest(3, [4, 5, 8, 2]).add(10))
print(KthLargest(3, [4, 5, 8, 2]).add(9))
print(KthLargest(3, [4, 5, 8, 2]).add(4))