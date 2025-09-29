class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n == 1:
            return 0
        if k % 2 == 0:
            return 1 - self.kthGrammar(n - 1,  k // 2)
        return self.kthGrammar(n - 1, (k + 1) // 2)

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