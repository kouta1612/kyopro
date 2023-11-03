package main

import "fmt"

type point struct {
	x, y int
}

func main() {
	var y, x int
	fmt.Scan(&y, &x)

	m := make([][]int, x+2)
	for i := 0; i < x+2; i++ {
		m[i] = make([]int, y+2)

		if i == 0 || i == x+1 {
			continue
		}

		for j := 1; j < y+1; j++ {
			fmt.Scan(&m[i][j])
		}
	}

	dx := [2][]int{
		[]int{0, 1, 1, 0, -1, -1},
		[]int{0, 1, 1, 0, -1, -1},
	}
	dy := [2][]int{
		[]int{1, 0, -1, -1, -1, 0},
		[]int{1, 1, 0, -1, 0, 1},
	}

	visited := make(map[point]bool)
	q := make([]point, 0)
	q = append(q, point{x: 0, y: 0})
	visited[point{x: 0, y: 0}] = true
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		for i := 0; i < 6; i++ {
			nx := now.x + dx[now.x%2][i]
			ny := now.y + dy[now.x%2][i]
			next := point{x: nx, y: ny}
			if nx < 0 || nx > x+1 || ny < 0 || ny > y+1 {
				continue
			}
			if m[nx][ny] == 1 {
				continue
			}
			if visited[next] {
				continue
			}

			visited[next] = true
			q = append(q, next)
		}
	}

	for i := 0; i < x+2; i++ {
		for j := 0; j < y+2; j++ {
			if !visited[point{x: i, y: j}] {
				m[i][j] = 1
			}
		}
	}

	result := 0
	for i := 0; i < x+2; i++ {
		for j := 0; j < y+2; j++ {
			if m[i][j] == 1 {
				continue
			}

			for k := 0; k < 6; k++ {
				nx := i + dx[i%2][k]
				ny := j + dy[i%2][k]

				if nx < 0 || nx > x+1 || ny < 0 || ny > y+1 {
					continue
				}
				if m[nx][ny] == 0 {
					continue
				}

				result++
			}
		}
	}

	fmt.Println(result)
}
