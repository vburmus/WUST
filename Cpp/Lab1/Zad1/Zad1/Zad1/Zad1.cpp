//1. Napisz funkcję void v_alloc_table_fill_34(int iSize), która dynamicznie
//alokuje jednowymiarową tablicę zmiennych typu int.Alokowana tablica ma mieć
//rozmiar podany w parametrze(iSize).Wartości zmiennych w tablicy mają mieć
//wartość 34.
//Po zaalokowaniu tablicy i wypełnieniu jej wartościami, wypisz stan tablicy na ekranie.
//Pamiętaj o konieczności skasowania(dealokacji) tablicy.
//Zabezpiecz funkcję przed nieprawidłową wartością paramteru iSize.Czy ta funkcja
//będzie użyteczna i wygodna jeśli będzie wypisywać wartości na ekran w przypadku
//błędu ?
//Czy wartość 34 powinna występować bezpośrednio w kodzie
//v_alloc_table_fill_34 ?
#include <iostream>
#include "Vars.h";


void alloc_table_fill(int iSize);
void show(int* array, int iSize);

void alloc_table_fill(int iSize) {

	int* array;
	array = new int[10];
	for (int i = 0; i < iSize; i++) {
		array[i] = DEFAULT_VALUE;
	}
	show(array, iSize);
	delete[] array;
}
void show(int* array, int iSize) {
	if (iSize > 0) {
		std::cout << "Array size  - " << iSize << std::endl;
		for (int i = 0; i < iSize; i++) {
			std::cout << array[i] << " ";
		}
	}
	else
		std::cout << "Error size provided";
}
  

int main()
{
	alloc_table_fill(8);	
}

