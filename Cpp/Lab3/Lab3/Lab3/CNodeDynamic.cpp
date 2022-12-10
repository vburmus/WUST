#include "CNodeDynamic.h"
#include<vector>
using std::cout;
using std::endl;
using std::vector;
CNodeDynamic::CNodeDynamic()
{
	cout << "constructor node" << "\n";
	i_val = 0;
	pc_parent_node = NULL;
}

CNodeDynamic::~CNodeDynamic()
{
	std::cout << "destructor node" << "\n";
	for (int i = 0; i < v_children.size(); i++)
	{
		delete v_children[i];
	}

}

void CNodeDynamic::vSetValue(int iNewVal)
{
	i_val = iNewVal;
}

int CNodeDynamic::iGetChildrenNumber()
{
	return v_children.size();
}

void CNodeDynamic::vAddNewChild()
{
	CNodeDynamic* child = new CNodeDynamic();
	child->pc_parent_node = this;
	v_children.resize(v_children.size() + 1);
	v_children[v_children.size() - 1] = child;
}

CNodeDynamic* CNodeDynamic::pcGetChild(int iChildOffset)
{
	if (iChildOffset > -1 && iChildOffset < v_children.size())
	{
		return v_children[iChildOffset];
	}
	else return NULL;
}

void CNodeDynamic::vPrint()
{
	cout << " " << i_val;
}

void CNodeDynamic::vPrintAllBelow()
{
	vPrint();
	for (int i = 0; i < v_children.size(); i++)
	{
		v_children[i]->vPrintAllBelow();
	}
}

void CNodeDynamic::vAddChild(CNodeDynamic* child)
{
	child->pc_parent_node = this;
	v_children.push_back(child);
}

bool CNodeDynamic::bDelete(CNodeDynamic* child)
{
	//trzeba zastanowić
	if (std::find(v_children.begin(), v_children.end(), child) != v_children.end()) {
		vector<CNodeDynamic*> v_copy;
		int j = 0;
		for (int i = 0; i < v_children.size(); i++) {
			if (child != v_children[i]) {
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

CNodeDynamic* CNodeDynamic::getParent()
{
	return this->pc_parent_node;
}

