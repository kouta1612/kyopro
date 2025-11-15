from typing import Optional

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        res = []

        def dfs(node: Optional[TreeNode]):
            if not node: 
                res.append("N")
                return
            res.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return ",".join(res)

    def deserialize(self, data):
        it = iter(data.split(','))

        def dfs() -> Optional[TreeNode]:
            v = next(it)
            if v == "N": return None
            cur = TreeNode(v)
            cur.left, cur.right = dfs(), dfs()
            return cur
        return dfs()

print(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3))))
print(Codec().deserialize(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3)))))
print(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3))))