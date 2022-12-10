#include "CTable.h"
using std::string;
using std::cout;
using std::endl;

CTable::CTable()
{
	sName = DEFAULT_TITLE;
	iTableLen = DEFAULT_LENGTH;
	piTable = new int[DEFAULT_LENGTH];
	cout << "bezp.: '" << sName << "' " << endl;
}

CTable::CTable(string name, int tabLength)
{
	sName = name;
	iTableLen = tabLength;
	piTable = new int[tabLength];
	cout << "parametr.: '" << sName << "' " << endl;
}

CTable::CTable(CTable& pcaOther)
{
	sName = pcaOther.sName + "_copy";
	iTableLen = pcaOther.iTableLen;
	piTable = new int[iTableLen];
	for (int i = 0; i < iTableLen; i++)
	{
		piTable[i] = pcaOther.piTable[i];
	}
	cout << "kopiuj.: '" << sName << "' " << endl;
}

CTable::~CTable()
{
	cout << "usuwam: '" << sName << "' " << endl;
	delete[] piTable;

}
void CTable::vSetName(string newName)
{

	cout << "zmiana: " << sName << "->" << newName << endl;
	sName = newName;
}
bool CTable::bSetNewSize(int newLength)
{
	if (newLength > 0 && newLength != iTableLen)
	{
		int* piNewTable = new int[newLength];
		if (iTableLen <= newLength)
		{
			for (int i = 0; i < iTableLen; i++)
			{
				piNewTable[i] = piTable[i];
			}
			iTableLen = newLength;
		}
		else
		{
			for (int i = 0; i < newLength; i++)
			{
				piNewTable[i] = piTable[i];
			}
			iTableLen = newLength;
		}
		delete[] piTable;
		piTable = NULL;
		piTable = piNewTable;
		return true;
	}
	else
	{
		return false;
	}
}
CTable* CTable::pcClone()
{
	CTable* clonedTab = new CTable(sName + "_clone", iTableLen);
	for (int i = 0; i < iTableLen; i++)
		clonedTab->piTable[i] = piTable[i];
	return clonedTab;
}
int CTable::getLength()
{
	return iTableLen;
}
string CTable::getName()
{
	return sName;
}
sCTable& CTable::operator=(CTable& pcOther)
{
	delete[] piTable;
	iTableLen = pcOther.iTableLen;
	piTable = new int[iTableLen];
	for (int i = 0; i < iTableLen; i++)
	{
		piTable[i] = pcOther.piTable[i];
	}
	return *this;
}
CTable CTable::operator+(CTable& pcOther)
{
	CTable unionTab;
	unionTab.bSetNewSize(pcOther.iTableLen + this->iTableLen);
	for (int i = 0; i < this->iTableLen; i++)
	{
		unionTab.piTable[i] = this->piTable[i];
	}

	for (int i = this->iTableLen, j = 0; j < unionTab.iTableLen;i++,j++)
	{
		unionTab.piTable[i] = pcOther.piTable[j];
	}
	return unionTab;
}

void CTable::operator++(int)
{
		this->bSetNewSize(this->iTableLen + 1);
		this->vSetValueAt(this->iTableLen - 1, 0);
}



bool CTable::vSetValueAt(int iOffset, int iNewVal)
{
	if (iOffset >= 0 && iOffset < iTableLen) {
		piTable[iOffset] = iNewVal;
		return true;
	}
	return false;
}

void CTable::vPrint()
{
	for (int i = 0; i < iTableLen; i++) {
		cout << piTable[i] << " ";
	}
	cout << endl;
}
