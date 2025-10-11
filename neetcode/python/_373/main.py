from heapq import heappush, heappop
from typing import List

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        q, res, s = [(nums1[0] + nums2[0], 0, 0)], [], set((0, 0))
        while q:
            v, i, j = heappop(q)
            res.append([nums1[i], nums2[j]])
            if len(res) == k: break
            if i + 1 < len(nums1) and (i + 1, j) not in s:
                heappush(q, (nums1[i+1] + nums2[j], i + 1, j))
                s.add((i+1, j))
            if j + 1 < len(nums2) and (i, j + 1) not in s:
                heappush(q, (nums1[i] + nums2[j+1], i, j + 1))
                s.add((i, j+1))
        return res



print(Solution().kSmallestPairs([1, 7, 11], [2, 4, 6], 3))
print(Solution().kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
print(Solution().kSmallestPairs([1, 2], [3], 3))