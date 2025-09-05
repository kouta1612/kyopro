import heapq
from typing import List

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heapnums = nums
        heapq.heapify(self.heapnums)

    def add(self, val: int) -> int:
        heapq.heappush(self.heapnums, val)
        while len(self.heapnums) > self.k:
            heapq.heappop(self.heapnums)
        res = heapq.heappop(self.heapnums)
        heapq.heappush(self.heapnums, res)
        return res

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

print(KthLargest(3, [4, 5, 8, 2]).add(3))
print(KthLargest(3, [4, 5, 8, 2]).add(5))
print(KthLargest(3, [4, 5, 8, 2]).add(10))
print(KthLargest(3, [4, 5, 8, 2]).add(9))
print(KthLargest(3, [4, 5, 8, 2]).add(4))