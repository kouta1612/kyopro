from heapq import heappush, heappop
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        mp = dict()
        for num in nums:
            if num in mp:
                mp[num] += 1
            else:
                mp[num] = 1
        
        heap = []
        for key, c in mp.items():
            heappush(heap, (-c, key))
        
        res = []
        for i in range(k):
            v = heappop(heap)
            res.append(v[1])
        return res

print(Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2))