package main

import (
	"container/list"
	"fmt"
)

func main() {
	list := list.New()

	now := list.PushBack(0)
	_ = list.InsertAfter(1, now)

	for v := list.Front(); v != nil; v = v.Next() {
		fmt.Println(v.Value)
	}
}
