from types import List
from collections import defaultdict

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = defaultdict(list)
        for src, dest in sorted(tickets, reverse=True):
            graph[src].append(dest)

        res = []
        def dfs(src: int):
            while graph[src]:
                dfs(graph[src].pop())
            res.append(src)
        
        dfs("JFK")
        return res[::-1]

print(Solution().findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]))