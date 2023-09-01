#include <iostream>
using namespace std;
int main() {
	bool invalid = false;
	int i = 0, j = 0, num;
	cin >> num;
	while (1) {
		//N의 범위가 3이상이므로 앞에서 제약 조건 안걸어도 됨
		if (num % 5 == 0)
		{
			j = num / 5; 
			num = num - j * 5; break;
		}
		num = num - 3; i++;
		if (num == 0) break;
		if (num<0) invalid = true;
	}
	if (!invalid)  cout << i + j << endl;
	else cout << -1;
}