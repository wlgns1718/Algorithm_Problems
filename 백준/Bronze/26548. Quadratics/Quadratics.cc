#include <iostream>
#include <cmath>
using namespace std;
typedef long double ld;

int T;

ld a, b, c;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cout << fixed;
	cout.precision(3);

	cin >> T;
	while (T--) {
		cin >> a >> b >> c;
		cout << (-b + sqrt(b * b - 4 * a * c)) / (2 * a) << ", " << (-b - sqrt(b * b - 4 * a * c)) / (2 * a) << '\n';
	}
}