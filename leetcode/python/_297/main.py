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
        vals = data.split(',')
        self.i = 0

        def dfs() -> Optional[TreeNode]:
            if vals[self.i] == "N": 
                self.i += 1
                return None
            cur = TreeNode(int(vals[self.i]))
            self.i += 1
            cur.left, cur.right = dfs(), dfs()
            return cur
        return dfs()

print(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3))))
print(Codec().deserialize(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3)))))
print(Codec().serialize(TreeNode(1, TreeNode(2), TreeNode(3))))