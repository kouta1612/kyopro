import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        i,j = 0, len(s)-1
        pattern = re.compile("[a-z0-9]")

        while i <= j:
            if not pattern.match(s[i]):
                i += 1
                continue
            if not pattern.match(s[j]):
                j -= 1
                continue
            if s[i] != s[j]:
                return False

            i += 1
            j -= 1
        
        return True

print(Solution().isPalindrome("A man, a plan, a canal: Panama"))