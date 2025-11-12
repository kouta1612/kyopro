class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t: return s
        smap, tmap = {}, {}
        for c in t:
            tmap[c] = tmap.get(c, 0) + 1
        
        l, r = 0, 0
        counter, required = 0, len(tmap)
        res = ""
        minlen = float('inf')
        while r < len(s):
            c = s[r]
            smap[c] = smap.get(c, 0) + 1
            if c in tmap and smap[c] == tmap[c]: counter += 1
            r += 1
            while l < len(s) and counter == required:
                if minlen > r - l:
                    minlen = r - l
                    res = s[l:r]
                if s[l] in tmap and smap[s[l]] == tmap[s[l]]:
                    counter -= 1
                smap[s[l]] -= 1
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