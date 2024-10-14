package main

import (
	"fmt"

	"github.com/liyue201/gostl/ds/deque"
)

func main() {
	deq := deque.New[int]()
	deq.PushBack(1)
	deq.PushFront(2)

	for deq.Size() > 0 {
		fmt.Println(deq.PopFront())
	}
}
