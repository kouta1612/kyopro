from heapq import heappush, heappop
from typing import List

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heaps = []
        for num in nums: heappush(self.heaps, num)
        while len(self.heaps) > self.k: heappop(self.heaps)

    def add(self, val: int) -> int:
        heappush(self.heaps, val)
        if len(self.heaps) > self.k: heappop(self.heaps)
        return self.heaps[0]

print(KthLargest(3, [4, 5, 8, 2]).add(3))
print(KthLargest(3, [4, 5, 8, 2]).add(5))
print(KthLargest(3, [4, 5, 8, 2]).add(10))
print(KthLargest(3, [4, 5, 8, 2]).add(9))
print(KthLargest(3, [4, 5, 8, 2]).add(4))