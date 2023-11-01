package main

import "fmt"

type point struct {
	x, y int
}

func main() {
	var m int
	fmt.Scan(&m)

	a := make([]point, m)
	for i := 0; i < m; i++ {
		var x, y int
		fmt.Scan(&x, &y)

		a[i] = point{x: x, y: y}
	}

	var n int
	fmt.Scan(&n)

	b := make([]point, n)
	mp := make(map[point]bool)
	for i := 0; i < n; i++ {
		var x, y int
		fmt.Scan(&x, &y)

		b[i] = point{x: x, y: y}
		mp[b[i]] = true
	}

	for i := 0; i < n; i++ {
		// 平行移動する量
		dx := b[i].x - a[0].x
		dy := b[i].y - a[0].y

		c := make([]point, m)
		copy(c, a)
		for j := 0; j < m; j++ {
			c[j].x = a[j].x + dx
			c[j].y = a[j].y + dy
		}

		ok := true
		for j := 0; j < m; j++ {
			if !mp[point{x: c[j].x, y: c[j].y}] {
				ok = false
			}
		}

		if ok {
			fmt.Println(dx, dy)
		}
	}
}
