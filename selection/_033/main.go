package main

import "fmt"

const INF = 1 << 30

var dx = []int{0, -1, 0, 1}
var dy = []int{1, 0, -1, 0}

type point struct {
	x, y int
}

func main() {
	var h, w int
	fmt.Scan(&h, &w)

	s := make([]string, h)
	for i := 0; i < h; i++ {
		fmt.Scan(&s[i])
	}

	m := make([][]int, h)
	for i := 0; i < h; i++ {
		m[i] = make([]int, w)
		for j := 0; j < w; j++ {
			if s[i][j] == '#' {
				m[i][j] = INF
			}
		}
	}

	m[0][0] = 1
	q := make([]point, 0)
	q = append(q, point{x: 0, y: 0})
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		for i := 0; i < 4; i++ {
			nx := now.x + dx[i]
			ny := now.y + dy[i]

			if nx < 0 || nx > h-1 || ny < 0 || ny > w-1 {
				continue
			}
			if m[nx][ny] > 0 {
				continue
			}

			m[nx][ny] = m[now.x][now.y] + 1
			q = append(q, point{x: nx, y: ny})
		}
	}

	if m[h-1][w-1] == 0 {
		fmt.Println(-1)
		return
	}

	q = append(q, point{x: h - 1, y: w - 1})
	results := make([]point, 0)
	results = append(results, point{x: h - 1, y: w - 1})
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		if now.x == 0 && now.y == 0 {
			break
		}

		for i := 0; i < 4; i++ {
			nx := now.x + dx[i]
			ny := now.y + dy[i]

			if nx < 0 || nx > h-1 || ny < 0 || ny > w-1 {
				continue
			}
			if m[nx][ny] != m[now.x][now.y]-1 {
				continue
			}

			results = append(results, point{x: nx, y: ny})
			q = append(q, point{x: nx, y: ny})
			break
		}
	}

	result := h*w - len(results)
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if s[i][j] == '#' {
				result--
			}
		}
	}

	fmt.Println(result)
}
