from heapq import heappush, heappop
from typing import List
from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)
        for num in nums:
            freq[num] += 1
        counters = [[] for _ in range(len(nums) + 1)]
        for v, c in freq.items():
            counters[c].append(v)

        res = []
        for c in range(len(nums), -1, -1):
            if not counters[c]: continue
            for v in counters[c]:
                res.append(v)
                if len(res) >= k:
                    return res
        

print(Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2))