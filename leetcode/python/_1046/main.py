from typing import List
from heapq import heappush, heappop

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heaps = []
        for stone in stones:
            heappush(heaps, -stone)
        
        while len(heaps) > 1:
            tmp1, tmp2 = -heappop(heaps), -heappop(heaps)
            if tmp1 != tmp2: heappush(heaps, -abs(tmp2 - tmp1))
        
        return -heaps[0] if heaps else 0

print(Solution().lastStoneWeight([2, 7, 4, 1, 8, 1]))