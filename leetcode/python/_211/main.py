from typing import Optional

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isWord = True

    def search(self, word: str) -> bool:
        def dfs(i: int, node: Optional[TrieNode]) -> bool:
            if not node: return False
            if i == len(word): return node.isWord
            c = word[i]
            if c == ".":
                for nd in node.children.values():
                    if dfs(i + 1, nd): return True
                return False
            if c not in node.children: return False

            return dfs(i + 1, node.children[c])

        return dfs(0, self.root)

print(WordDictionary().addWord("bad").search("bad"))
print(WordDictionary().addWord("bad").search("dad"))
print(WordDictionary().addWord("bad").search("mad"))
print(WordDictionary().addWord("bad").search("pad"))
print(WordDictionary().addWord("bad").search("bad"))
print(WordDictionary().addWord("bad").search("bad"))