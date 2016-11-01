#include <iostream>
#include <Windows.h>
#include <MMSystem.h>
#include <string>

using namespace std;

int main() {
	string str;
	string* strPtr;
	strPtr = &str;
	for (size_t i = 0; i < 10; i++)
	{
		str = "piano\\" + to_string(i) + ".wav";
		PlaySound(TEXT(strPtr), NULL, SND_FILENAME);
	}
	


	system("pause");
	return 0;
}