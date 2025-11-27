from typing import List
from heapq import heappush, heappushpop

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heaps = []
        for num in nums:
            if len(heaps) < k: heappush(heaps, num)
            else: heappushpop(heaps, num)
        return heaps[0]

print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))