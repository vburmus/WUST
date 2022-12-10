#include "CNodeStatic.h"
#include <algorithm>
using std::cout;
using std::endl;
using std::vector;
CNodeStatic::CNodeStatic() { i_val = 0; pc_parent_node = NULL; };
void CNodeStatic::vSetValue(int iNewVal) { i_val = iNewVal; };

int CNodeStatic::iGetChildrenNumber() { return v_children.size(); }

void CNodeStatic::vAddNewChild()
{
	CNodeStatic child;
	child.pc_parent_node = this;
	v_children.push_back(child);
}

void CNodeStatic::vAddChild(CNodeStatic child)
{
	v_children.push_back(child);
}


CNodeStatic* CNodeStatic::pcGetChild(int iChildOffset)
{
	if (iChildOffset > -1 && iChildOffset < v_children.size())
	{
		return &v_children[iChildOffset];
	}
	else return NULL;
}



CNodeStatic* CNodeStatic::getParent()
{
	return this->pc_parent_node;
}

void CNodeStatic::vPrint() { cout << " " << i_val; };

void CNodeStatic::vPrintAllBelow()
{
	vPrint();
	
	for (int i = 0; i < v_children.size(); i++)
	{
		v_children[i].vPrintAllBelow();
	}
	
}

bool CNodeStatic::bDelete(CNodeStatic* child)
{
	if (std::find(v_children.begin(), v_children.end(), child) != v_children.end()) {

	vector<CNodeStatic> v_copy;
	int j = 0;
	for (int i = 0; i < v_children.size(); i++) {
		if (( child) != &v_children[i]) {
			v_copy.resize(v_copy.size() + 1);
			v_copy[j] = v_children[i];
			j++;
		}

	}
	v_children = v_copy;
	return true;
	}
	return false;
}
void CNodeStatic::vPrintUp()
{
	vPrint();
	if (pc_parent_node != NULL)
	{
		pc_parent_node->vPrintUp();
	}
}


bool CNodeStatic::setParent(CNodeStatic* parent)
{
		pc_parent_node = parent;
		return true;
}