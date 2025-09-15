from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s = set()
        for num in nums1:
            s.add(num)
        
        res = set()
        for num in nums2:
            if num in s:
                res.add(num)
        
        return list(res)

print(Solution().intersection([1, 2, 2, 1], [2, 2]))
print(Solution().intersection([4, 9, 5], [9, 4, 9, 8, 4]))