class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            odd = self.expand(i, i, s)
            if len(res) < len(odd): res = odd
            even = self.expand(i, i + 1, s)
            if len(res) < len(even): res = even
        return res
            
    def expand(self, l, r: int, s: str) -> str:
        res = ""
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if len(res) < len(s[l:r+1]): res = s[l:r+1]
            l -= 1
            r += 1
        return res

print(Solution().longestPalindrome("babad"))
print(Solution().longestPalindrome("cbbd"))