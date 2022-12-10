//2. Napisz funkcję
//bool b_alloc_table_2_dim(int ? ? ? piTable, int iSizeX, int iSizeY); , która:
//
//Alokuje dwuwymiarową tablicę dla typu int, dla parameteru podanego w piTable.
//Alokacja ma być wykonana tak, żeby w przypadku wywołania.
//int** pi_table;
//b_alloc_table_2_dim(? ? ? pi_table, 5, 3);
//pi_table ma wskazywać na tablicę dla typu int o wymiarach 5 * 3.
//Jeżeli operacja się uda funkcja ma zwrócić wartość true, lub false w przeciwnym
//przypadku.
//Zastanów się jak dokładnie co wstawić zamiast ? ? ? , jeżeli użycie referencji jest
//niemożliwe.

//3. Napisz funkcję
//bool b_dealloc_table_2_dim(int ? ? ? piTable, int iSizeX, int iSizeY); , która
// Dealokuje dwuwymiarową tablicę typu int.
//„ZPR PWr – Zintegrowany Program Rozwoju Politechniki Wrocławskiej”
//14 / 15
// Jeżeli operacja się uda funkcja ma zwrócić wartość true, lub false w
//przeciwnym przypadku.
// Zastanów się jak dokładnie co wstawić zamiast ? ? ? , jeżeli użycie referencji jest
//niemożliwe.Czy będzie jakaś różnica w porównaniu z b_alloc_table_2_dim ?
// Czy b_dealloc_table_2_dim może mieć mniej parametrów ?
#include <iostream>


bool alloc_table_2_dim(int **&piTable, int iSizeX, int iSizeY); 
bool dealloc_table_2_dim(int **&piTable, int iSizeX);
void show(bool result);

bool alloc_table_2_dim(int **&piTable, int iSizeX, int iSizeY) {
	if (iSizeX <= 0 || iSizeY <= 0) 
		return false;
	else {
		piTable = new int* [iSizeX];
		for (int i = 0; i < iSizeX; i++) {
			piTable[i] = new int[iSizeY];
		}
		return true;
	}
}
bool dealloc_table_2_dim(int**& piTable, int iSizeX)
{
	if (iSizeX <= 0) 
		return false;
	else {
		for (int i = 0; i < iSizeX; i++)
			delete piTable[i];
		delete piTable;
	}
	
	}
void show(bool result) {
	std::cout << " Result - "
		<< std::boolalpha
		<< result
		<< std::endl;
}
void main()
{
	int** pi_table;
	bool result =  alloc_table_2_dim(pi_table, 4, 4);
	show(result);
	result = dealloc_table_2_dim(pi_table, 4);
	show(result);
}
