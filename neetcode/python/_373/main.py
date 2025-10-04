from heapq import heappush, heappop
from typing import List

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        h = []
        for i in range(min(len(nums2), k)):
            heappush(h, [nums1[0] + nums2[i], 0, i])
        
        res = []
        while len(h) > 0 and len(res) < k:
            _, i, j = heappop(h)
            res.append([nums1[i], nums2[j]])
            if i + 1 < len(nums1): heappush(h, [nums1[i + 1] + nums2[j], i + 1, j])
        
        return res

print(Solution().kSmallestPairs([1, 7, 11], [2, 4, 6], 3))
print(Solution().kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
print(Solution().kSmallestPairs([1, 2], [3], 3))