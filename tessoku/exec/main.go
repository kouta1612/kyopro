package main

import (
	"fmt"
)

type Point struct {
	x int
	y int
}

func main() {
	const INF = 10000
	var dx = []int{0, -1, 1, 0}
	var dy = []int{1, 0, 0, -1}

	var r, c int
	fmt.Scan(&r, &c)

	var sy, sx, gy, gx int
	fmt.Scan(&sy, &sx, &gy, &gx)
	sy -= 1
	sx -= 1
	gy -= 1
	gx -= 1

	maps := make([]string, r)
	dist := make([][]int, r)
	for i := 0; i < r; i++ {
		var s string
		fmt.Scan(&s)
		maps[i] = s
		dist[i] = make([]int, c)
	}

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if string(maps[i][j]) == "#" {
				dist[i][j] = INF
			}
		}
	}
	dist[sy][sx] = 0

	q := make([]Point, r*c)
	q = append(q, Point{x: sy, y: sx})
	for len(q) > 0 {
		now := q[0]
		q = q[1:]
		for i := 0; i < 4; i++ {
			nx := now.x + dx[i]
			ny := now.y + dy[i]
			if !(0 <= nx && nx < r && 0 <= ny && ny < c) {
				continue
			}
			if dist[nx][ny] == INF {
				continue
			}
			if dist[nx][ny] != 0 {
				continue
			}

			dist[nx][ny] = dist[now.x][now.y] + 1
			q = append(q, Point{x: nx, y: ny})
		}
	}

	fmt.Println(dist[gy][gx])
}
