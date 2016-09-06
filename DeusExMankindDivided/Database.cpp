#include "Database.h"



Database::Database()
{
}


Database::~Database()
{
}

void Database::setData(char* l, char* d, char* p)
{
	//get size of array
	//
	//loop in while looking for null spot
	int i = 0;
	while (location[i] != '\0')
	{
		i++;
	}
	//add data
	location[i] = *l;
	desc[i] = *d;
	pwdkey[i] = *p;


}
