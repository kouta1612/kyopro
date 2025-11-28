from typing import List

class Trie:

    def __init__(self):
        self.children = {}
        self.isWord = False

    def insert(self, word: str) -> None:
        cur = self
        for c in word:
            if c not in cur.children: cur.children[c] = Trie()
            cur = cur.children[c]
        cur.isWord = True

    def search(self, word: str) -> bool:
        cur = self
        for c in word:
            if c not in cur.children: return False
            cur = cur.children[c]
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        cur = self
        for c in prefix:
            if c not in cur.children: return False
            cur = cur.children[c]
        return True

print(Trie().insert("apple"))
print(Trie().search("apple"))
print(Trie().search("app"))
print(Trie().startsWith("app"))
print(Trie().insert("app"))
print(Trie().search("app"))