from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t: return s
        smap, tmap = {}, {}
        for c in t:
            tmap[c] = tmap.get(c, 0) + 1
        
        l, r = 0, 0
        counter = 0
        res = s + s
        while l < len(s):
            while r < len(s) and not (r > 0 and counter == len(tmap) and s[r-1] in smap and s[r-1] in tmap and smap[s[r-1]] == tmap[s[r-1]]):
                smap[s[r]] = smap.get(s[r], 0) + 1
                if smap[s[r]] == tmap.get(s[r], 0): counter += 1
                r += 1
            if counter == len(tmap) and len(res) >= r - l: res = s[l:r]
            if smap[s[l]] == tmap.get(s[l], 0): counter -= 1
            smap[s[l]] -= 1
            if smap[s[l]] == 0: del smap[s[l]]
            l += 1
        return res if res != s + s else ""

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