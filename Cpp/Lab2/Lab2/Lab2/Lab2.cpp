#include <iostream>
#include "CTable.h"
using std::boolalpha;
using std::cout;
using std::endl;


int main()
{
	//Zadanie 1
	/*Nie dziala. Bląd w delete_scalar.cpp :
	_CRT_SECURITYCRITICAL_ATTRIBUTE
	void __CRTDECL operator delete(void* const block) noexcept
	{
		#ifdef _DEBUG
		_free_dbg(block, _UNKNOWN_BLOCK);
		#else
		free(block);
		#endif
	}*/
	
	//CTable c_tab_0, c_tab_1;
	//c_tab_0.bSetNewSize(4);
	//c_tab_1.bSetNewSize(4);
	//c_tab_0 = c_tab_1;
	
	//Zadanie 2
	/*Skompilowal się bez blędów bez destruktora*/


	//Zadanie 3
	/*Skompilowal się bez blędów bez destruktora*/
	
	//CTable c_tab_0, c_tab_1;
	//c_tab_0.bSetNewSize(6);
	//c_tab_1.bSetNewSize(4);
	///* initialize table */
	//c_tab_0 = c_tab_1;
	//c_tab_1.vSetValueAt(2, 123);
	//c_tab_0.vPrint();
	//c_tab_1.vPrint();
	//Zadanie 4

	CTable c_tab_0, c_tab_1;
	c_tab_0.bSetNewSize(6);
	c_tab_1.bSetNewSize(4);
	c_tab_1.vSetName("test_1");
	c_tab_0.vSetValueAt(0, 1);
	c_tab_0.vSetValueAt(1, 2);
	c_tab_0.vSetValueAt(2, 3);
	c_tab_0.vSetValueAt(3, 4);
	c_tab_0.vSetValueAt(4, 5);
	c_tab_0.vSetValueAt(5, 6);
		
	c_tab_1.vSetValueAt(0, 51);
	c_tab_1.vSetValueAt(1, 52);
	c_tab_1.vSetValueAt(2, 53);
	c_tab_1.vSetValueAt(3, 54);


	c_tab_0.vPrint();
	c_tab_1.vPrint();

	(c_tab_0 + c_tab_1).vPrint();

	c_tab_0 = c_tab_1;
	c_tab_1.vSetValueAt(2, 999);
	c_tab_0.vPrint();
	c_tab_1.vPrint();
	/*
	Tablicy są identyczne, chociaż zmieniłem 
	c_tab_1, bo c_tab_0 oraz c_tab_1 zwracaja sie do
	takiej samej tablicy w stercie.

	W pierwszym zadaniu program zachowuje się w taki sposob
	bo usuwamy tablicę dynamiczną, która juz została usunięta
	przy wywolaniu destruktora za pierwszym razem,
	
	*/

	CTable c_obj;
	c_obj.vSetName("test_2");
	c_obj.bSetNewSize(3);
	c_obj.vSetValueAt(0, 1);
	c_obj.vSetValueAt(1, 2);
	c_obj.vSetValueAt(2, 3);
	c_obj++;
	c_obj.vPrint();

}