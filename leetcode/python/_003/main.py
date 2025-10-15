class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        l, r = 0, 0
        strSet = set()
        while l < len(s):
            while r < len(s) and s[r] not in strSet:
                strSet.add(s[r])
                r += 1
            res = max(res, r - l)
            strSet.remove(s[l])
            l += 1
        return res

print(Solution().lengthOfLongestSubstring("abcabcbb"))