#include <iostream>
#include "CTable.h"
using std::boolalpha;
using std::cout;
using std::endl;


int main()
{
	CTable c_tab_0, c_tab_1;
	c_tab_0.bSetNewSize(6);
	c_tab_1.bSetNewSize(4);
	c_tab_0 = c_tab_1;
 
}


