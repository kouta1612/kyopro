from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()

        res = []
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]: continue
            j, k = i + 1, n - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if s == 0:
                    res.append((nums[i], nums[j], nums[k]))
                    j += 1
                    k -= 1
                    while j < k and nums[j] == nums[j-1]: j += 1
                    while k > j and nums[k] == nums[k+1]: k -= 1
                elif s > 0:
                    k -= 1
                else:
                    j += 1
        return res

print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
print(Solution().threeSum([-4, -1, -1, 0, 1, 2]))