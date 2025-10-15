class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res, j, uniqs = 0, 0, set()
        for i in range(len(s)):
            while j < len(s) and s[j] not in uniqs:
                uniqs.add(s[j])
                j += 1
            res = max(res, j - i)
            uniqs.remove(s[i])
        return res
print(Solution().lengthOfLongestSubstring("abcabcbb"))