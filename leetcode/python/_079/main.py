from typing import List

class Solution:
    dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(r, c, i: int):
            if i >= len(word): return True
            if r < 0 or c < 0 or r >= len(board) or c >= len(board[0]):
                return False
            if word[i] != board[r][c]: return False

            tmp, board[r][c] = board[r][c], "#"
            for j in range(4):
                if dfs(r + self.dx[j], c + self.dy[j], i + 1): return True
            board[r][c] = tmp
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0): return True
        return False

print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))