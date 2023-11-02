# 第8回日本情報オリンピック本線（過去問） B-ピザ

## 反省

愚直に実装したらo(nm)で間に合わないので二分探索が必要とは思ったが
二分探索を「|Ti - Sj|が最小のjを選ぶ」と考えたときの具体的な実装が分からなかった。
また、円だとわかりにくいのでdnを番兵にして直線上に店舗を配置すれば良いことは思いつけたので良かった。

## 二分探索の方針

宅配iをTi、店舗をSjとする。(店鋪はソートされている前提)
Sj >= Tiを満たす最小のjをlower_boundで求めればTiから一番近い店鋪は
SiかSi-1のどれかであるので答えが求まる。（境界に注意して条件分岐する）
宅配場所は店鋪と店鋪の間に位置することを理解していれば上の方針がわかりやすくなる。