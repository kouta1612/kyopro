from heapq import heappush, heappop
from typing import List
from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)
        for num in nums:
            freq[num] += 1
        q = []
        for key, v in freq.items():
            heappush(q, (-v, key))

        res = []
        while len(res) < k:
            v = heappop(q)
            res.append(v[1])
        return res

print(Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2))