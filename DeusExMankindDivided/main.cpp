#include <iostream>
#include <fstream>
#include <string>

using namespace std;
int locSize;
int descsize;
int pksize;
//Function that will take pointer to first char in the name
//And print out the remaining contents
void nameConcat(std::string type , char* start, int size)
{
	std::cout << type << std::endl;
	for (int i = 0; i < size ; i++)
	{
		std::cout << *start;
		start++;
		//i++;
	}
	std::cout << ""<< std::endl;

}
void storeData(std::string data) {
	char* loc = "\0";
	char* desc = "\0";
	char* pk;

	
	//Break string
	for (int p = 0; p < data.length(); p++)
	{
		//If the character at position i is a forward-slash and loc is null
		//Might not work
		if (data.at(p) == '/' && locSize  == 0)
		{
			
			loc = new char[p];
			locSize = p;
			for (int j = 0; j < locSize; j++)
			{
				loc[j] = data.at(j);
				
			}
			//std::cout << p << std::endl;
			
		
		}
		else if (data.at(p) == '/' && desc == '\0' && loc != '\0')
		{
			desc = new char[p - locSize];
			descsize = p - locSize;
			for (int j = 0; j < descsize; j++)
			{
				desc[locSize+j] = data.at(locSize + j);

			}
		}
		//else if (data.at[i] == "/" && desc != nullptr && loc != nullptr)
		//{
			//pk = new char[i- locSize -descsize];
			//pksize = i - locSize - descsize;
		//}
	}

	//std::cout << "Location size " << locSize<< std::endl;
	nameConcat("Location is :", loc, locSize);
	nameConcat("Description is :",desc, descsize);
	//std::cout << "Description size " <<descsize << std::endl;
	//std::cout << "Pwd Keycode size " <<pksize << std::endl;
	
	//Crash when you delete the pointers
	//	delete loc;

	//delete desc;
	//delete pk;

};

int main()
{
	
	//Open file in read mode;
	ifstream file("C:\\Users\\Default\\Desktop\\deusex.txt");
	string content;
	string delim = "/";
	int start = 0;

	while (file >> content) {
		//cout << content << std::endl;
		storeData(content);
		system("PAUSE");
	}
	system("PAUSE");
}