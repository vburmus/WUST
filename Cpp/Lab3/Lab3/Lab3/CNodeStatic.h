#pragma once
#include <iostream>
#include <vector>
using std::vector;

class CNodeStatic
{
public:
	CNodeStatic();
	/*~CNodeStatic();*/

	void vSetValue(int iNewVal);

	int iGetChildrenNumber();
	//Dodawanie nowego dziecka do vectora dzieci
	void vAddNewChild();
	void vAddChild(CNodeStatic child);
	//Zwraca dziecko o danym offsecie
	CNodeStatic* pcGetChild(int iChildOffset);
	//kostylidze
	CNodeStatic* getParent();
	bool bDelete(CNodeStatic* child);
	//dla danego wezla
	void vPrint();
	//dla ponizszych wezlow
	void vPrintAllBelow();
	void vPrintUp();
	bool setParent(CNodeStatic* parent);
private:
	vector<CNodeStatic> v_children;
	CNodeStatic* pc_parent_node;
	int i_val;
};

