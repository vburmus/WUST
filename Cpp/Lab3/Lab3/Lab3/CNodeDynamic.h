#pragma once
#include <iostream>
#include <vector>
using std::vector;
class CNodeDynamic
{
public:
	CNodeDynamic();
	~CNodeDynamic();

	void vSetValue(int iNewVal);

	int iGetChildrenNumber();
	void vAddNewChild();
	CNodeDynamic* pcGetChild(int iChildOffset);
	void vAddChild(CNodeDynamic* child);
	bool bDelete(CNodeDynamic* child);
	CNodeDynamic* getParent();

	void vPrint();
	void vPrintAllBelow();
	
private:
	vector<CNodeDynamic*> v_children;
	CNodeDynamic* pc_parent_node;
	int i_val;
};

