from heapq import heappush
from types import List
from collections import defaultdict

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        res = []

        graph = defaultdict(list)
        for start, end in tickets: heappush(graph[start], end)

        def dfs(node: str):
            while graph[node]:
                next_node = heappop(graph[node])
                dfs(next_node)
            res.append(node)

        dfs("JFK")
        return res[::-1]

print(Solution().findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]))