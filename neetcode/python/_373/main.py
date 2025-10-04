from heapq import heappush, heappop
from typing import List

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        h = []
        for i in range(min(len(nums1), k)):
            heappush(h, [nums1[i] + nums2[0], i, 0])
        
        res = []
        while len(h) > 0 and len(res) < k:
            _, i, j = heappop(h)
            res.append([nums1[i], nums2[j]])
            if j + 1 < len(nums2): heappush(h, [nums1[i] + nums2[j + 1], i, j + 1])
        
        return res

print(Solution().kSmallestPairs([1, 7, 11], [2, 4, 6], 3))
print(Solution().kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
print(Solution().kSmallestPairs([1, 2], [3], 3))