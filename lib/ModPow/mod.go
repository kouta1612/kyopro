package modpow

func ModPow(a, b, mod int) int {
	ret := 1
	for b > 0 {
		if b&1 == 1 {
			ret = ret * a % mod
		}
		a = a * a % mod
		b >>= 1
	}

	return ret
}
