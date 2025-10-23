class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.children: cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.endOfWord = True

    def search(self, word: str) -> bool:
        def dfs(j: int, root: TrieNode) -> bool:
            cur = root
            for i in range(j, len(word)):
                if word[i] == ".": 
                    for c in cur.children.values():
                        if dfs(i + 1, c): return True
                if word[i] not in cur.children: return False
                cur = cur.children[word[i]]
            return cur.endOfWord
        return dfs(0, self.root)

print(WordDictionary().addWord("bad").search("bad"))
print(WordDictionary().addWord("bad").search("dad"))
print(WordDictionary().addWord("bad").search("mad"))
print(WordDictionary().addWord("bad").search("pad"))
print(WordDictionary().addWord("bad").search("bad"))
print(WordDictionary().addWord("bad").search("bad"))