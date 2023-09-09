package nextpermutation

func Permutation(a []int) bool {
	// a[l] < a[l+1]を満たす最大のlを求める
	l := -1
	for i := 0; i < len(a)-1; i++ {
		if a[i] < a[i+1] {
			l = i
		}
	}

	if l == -1 {
		return false
	}

	// a[l] < a[r]を満たす最大のrを求める
	r := len(a) - 1
	for i := r; i > l; i-- {
		if a[l] < a[i] {
			r = i
			break
		}
	}

	a[l], a[r] = a[r], a[l]
	if r != len(a) {
		for i := l + 1; i < len(a)-1; i++ {
			a[i], a[i+1] = a[i+1], a[i]
		}
	}

	return true
}
