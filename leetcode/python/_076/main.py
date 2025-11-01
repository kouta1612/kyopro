from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        maps, mapt = defaultdict(int), defaultdict(int)
        for c in t: mapt[c] += 1
        have, need = 0, len(mapt)

        res = ""
        l, r = 0, 0
        while l < len(s):
            while r < len(s) and have < need:
                c = s[r]
                maps[c] += 1
                if c in mapt and maps[c] == mapt[c]: have += 1
                r += 1
            if have == need and (not res or len(res) > len(s[l:r])):
                res = s[l:r]
            if s[l] in mapt and maps[s[l]] == mapt[s[l]]: have -= 1
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