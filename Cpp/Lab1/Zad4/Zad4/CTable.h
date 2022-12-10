#pragma once
#include <string.h>
#include <iostream>
using std::string;
class CTable
{
private:
	string sName;
	int iTableLen;
	int* piTable;

public:
	const int DEFAULT_LENGTH = 5;
	const string DEFAULT_TITLE = "test_0";
	CTable();
	CTable(string name, int length);
	CTable(CTable& pcaOther);
	
	~CTable();

	void vSetName(string newName);
	bool bSetNewSize(int newTabLength);
	CTable* pcClone();
	int getLength();
	string getName();

	void operator= (const CTable &pcOther);
};

