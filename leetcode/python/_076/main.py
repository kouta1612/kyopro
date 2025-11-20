from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        smap, tmap = defaultdict(int), defaultdict(int)
        for c in t: tmap[c] += 1

        required = len(tmap)
        counter = 0
        l, r, n = 0, 0, len(s)
        res, minLen = "", len(s)
        while r < n:
            smap[s[r]] += 1
            if s[r] in tmap and smap[s[r]] == tmap[s[r]]: counter += 1
            r += 1
            while l < n and required == counter:
                if r - l <= minLen:
                    res = s[l:r]
                    minLen = r - l
                smap[s[l]] -= 1
                if s[l] in tmap and smap[s[l]] + 1 == tmap[s[l]]: counter -= 1
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