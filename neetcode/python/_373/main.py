from heapq import heappush, heappop
from typing import List

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        heap, res = [], []
        for i in range(min(len(nums1), k)):
            heappush(heap, [nums1[i] + nums2[0], i, 0])

        while len(heap) > 0 and k > 0:
            s, i, j = heappop(heap)
            res.append([nums1[i], nums2[j]])
            if j + 1 < len(nums2):
                heappush(heap, [nums1[i] + nums2[j + 1], i, j + 1]) 
            k -= 1
        return res

print(Solution().kSmallestPairs([1, 7, 11], [2, 4, 6], 3))
print(Solution().kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
print(Solution().kSmallestPairs([1, 2], [3], 3))