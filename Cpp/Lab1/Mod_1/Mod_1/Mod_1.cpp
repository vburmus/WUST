
#include <iostream>
using std::cout;
using std::endl;
using std::boolalpha;

bool bAllocTriangle(int**& pi_table, int iSize);

bool bAllocTriangle(int**& pi_table, int iSize) {
	if (iSize > 0) {
		pi_table = new int* [iSize];
		for (int i = 0; i < iSize; i++) {
			pi_table[i] = new int[i + 1];
			for (int j = 0; j <= i; j++)
				pi_table[i][j] = (i + 1) * 10 + j + 1;
		}
		
		/*for (int i = 0; i < iSize; i++) {
			for (int j = 0; j <= i; j++)
				cout << pi_table[i][j] << " ";
			cout << endl;
		}*/
		return true;
	}
	else {
		return false;
	}

}
int main()
{
	int** pi_table;
	cout << boolalpha << bAllocTriangle(pi_table, 5) << endl;
	cout << "-----"<<endl;
	cout << boolalpha << bAllocTriangle(pi_table, 9) << endl;
}

