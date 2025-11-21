from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i-1]: continue
            j, k = i + 1, n - 1
            while j < k:
                c = nums[i] + nums[j] + nums[k]
                if c == 0:
                    res.append((nums[i], nums[j], nums[k]))
                    j += 1
                    while j < k and nums[j] == nums[j-1]:
                        j += 1
                elif c < 0:
                    j += 1
                else:
                    k -= 1
        return res

print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
print(Solution().threeSum([-4, -1, -1, 0, 1, 2]))