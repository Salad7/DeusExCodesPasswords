#pragma once
#include <iostream>
const int SIZE = 2;
class Database
{
public:
	Database();
	~Database();
	void setData(char* l, char* d, char* p);
private:
	char location[2];
	char desc[2];
	char pwdkey[2];
};

