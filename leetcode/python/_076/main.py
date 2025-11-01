from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        maps, mapt = defaultdict(int), defaultdict(int)
        for c in t: mapt[c] += 1

        l, r = 0, 0
        num = 0
        res = ""
        while l < len(s):
            while r < len(s) and num < len(mapt):
                if s[r] in mapt:
                    maps[s[r]] += 1
                    if maps[s[r]] == mapt[s[r]]:
                        num += 1
                r += 1
            if num == len(mapt):
                if not res or len(res) > len(s[l:r]):
                    res = s[l:r]
            if s[l] in maps:
                if maps[s[l]] == mapt[s[l]]: num -= 1
                maps[s[l]] -= 1
            l += 1
        return res

print(Solution().minWindow("ADOBECODEBANC", "ABC"))
print(Solution().minWindow("a", "a"))
print(Solution().minWindow("a", "aa"))
print(Solution().minWindow("ab", "a"))
print(Solution().minWindow("ab", "b"))
print(Solution().minWindow("ab", "ab"))
print(Solution().minWindow("ab", "ba"))
print(Solution().minWindow("ab", "abc"))
print(Solution().minWindow("abc", "abc"))
print(Solution().minWindow("abc", "abcd"))
print(Solution().minWindow("abc", "abcde"))