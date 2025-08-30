import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub("[^a-z0-9]", "", s)
        i,j = 0, len(s)-1

        while i <= j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
            

print(Solution().isPalindrome("A man, a plan, a canal: Panama"))