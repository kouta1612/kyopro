class Solution:
    def isPalindrome(self, s: str) -> bool:
        alnum = ""
        for c in s:
            if c.isalnum(): alnum += c
        alnum = alnum.lower()

        i, j = 0, len(alnum) - 1
        while i < j:
            if alnum[i] != alnum[j]: return False
            i += 1
            j -= 1
        return True

print(Solution().isPalindrome("A man, a plan, a canal: Panama"))