class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n == 1: return 0
        half = 1 << (n-2)
        if k <= half: return self.kthGrammar(n-1, k)
        return 1 - self.kthGrammar(n-1, k - half)

print(Solution().kthGrammar(1, 1))
print(Solution().kthGrammar(2, 1))
print(Solution().kthGrammar(2, 2))
print(Solution().kthGrammar(3, 1))
print(Solution().kthGrammar(3, 2))
print(Solution().kthGrammar(3, 3))
print(Solution().kthGrammar(4, 1))
print(Solution().kthGrammar(4, 2))
print(Solution().kthGrammar(4, 3))
print(Solution().kthGrammar(4, 4))