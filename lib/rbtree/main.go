package main

import (
	"fmt"

	"github.com/liyue201/gostl/ds/rbtree"
	"github.com/liyue201/gostl/utils/comparator"
)

func main() {
	// キーがソートされた状態でMapに登録される
	// 重複したキーを登録できる
	// 重複したキーが存在しても、そのキーを指定してDeleteをしたら単一のノードのみ削除される
	tree := rbtree.New[int, string](comparator.IntComparator)

	tree.Insert(1, "aaa")
	tree.Insert(5, "bbb")
	tree.Insert(3, "ccc")
	tree.Insert(3, "ccca")
	tree.Insert(3, "cccaa")

	v, _ := tree.Find(5)
	fmt.Printf("find %v returns %v\n", 5, v)

	if v := tree.FindNode(3); v != nil {
		tree.Delete(v)
	}

	tree.Traversal(func(key int, value string) bool {
		fmt.Printf("%v : %v\n", key, value)
		return true
	})
	tree.Delete(tree.FindNode(3))
}
