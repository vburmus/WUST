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

void CTable::operator=(const CTable& pcOther)
{
	piTable = pcOther.piTable;
	iTableLen = pcOther.iTableLen;
}
