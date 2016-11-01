#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void exercise1();
void exercise10();
bool areSame( vector<int> vecA, vector<int> vecB);
int areSameUntilPosition(vector<int> vecA, vector<int> vecB);
bool areSameReverse(vector<int> vecA, vector<int> vecB);

int main() {

	//exercise1();
	exercise10();

	system("pause");
	return 0;
}

void exercise1() {
	//1.	Write an application that will read in a number of integers from a file and store them in a vector. 
	//Allow the user to search through the vector and find the position of any user-defined number.

	std::ifstream inFile;
	inFile.open("integer.txt");

	int data;
	std::vector<int> numVector;

	while (!inFile.eof()) {
		inFile >> data;
		numVector.push_back(data);
	}

	int userInput = 0;
	std::cout << "Guess the number in the file, type -1 to quit" << std::endl;
	while(userInput != -1){
		std::cin >> userInput;

		for (int i = 0; i < numVector.size(); i++)
		{
			if (numVector[i] == userInput) {
				std::cout << "The number "<< numVector[i] <<" is in the file. It is at posttion " << i << std::endl;
			}
		}
	}

	inFile.close();
}

void exercise10() {
	//10.	Create a function, areSame(), that takes two vectors of integers and returns true if the vectors contain the same contents. 
	//Your function should work even if the contents are out of order.
	//testing the areSame method
	vector<int> vecA = { 1,2,3,4,5 };
	vector<int> vecB = { 1,2,3,4,5 };
	if(areSame(vecA,vecB)){
		cout << "Vector A and B are the same" << endl;
	}
	else {
		cout << "Vector A and B are NOT the same" << endl;
	}

	vecA = { 1,2,3,4,5 };
	vecB = { 1,2,3,4,5,6};
	if (areSame(vecA, vecB)) {
		cout << "Vector A and B are the same" << endl;
	}
	else {
		cout << "Vector A and B are NOT the same" << endl;
	}

	vecA = { 1,8,5,4,5 };
	vecB = { 7,2,3,4,5,6 };
	if (areSame(vecA, vecB)) {
		cout << "Vector A and B are the same" << endl;
	}
	else {
		cout << "Vector A and B are NOT the same" << endl;
	}

	vecA = { 1,2,10 };
	vecB = { 10,2,1 };
	if (areSame(vecA, vecB)) {
		cout << "Vector A and B are the same" << endl;
	}
	else {
		cout << "Vector A and B are NOT the same" << endl;
	}

}

bool areSame( vector<int> vecA, vector<int> vecB) {
	if (vecA.size() != vecB.size())
		return false;

	sort(begin(vecA), end(vecA));
	sort(begin(vecB), end(vecB));

	for (int i = 0; i < vecA.size();i++) {
		if (vecA[i] != vecB[i]) {
			return false;
		}
	}

	return true;
}

int areSameUntilPosition(vector<int> vecA, vector<int> vecB) {
	if (vecA.size() != vecB.size())
		return -1;

	sort(begin(vecA), end(vecA));
	sort(begin(vecB), end(vecB));

	for (int i = 0; i < vecA.size(); i++) {
		if (vecA[i] != vecB[i]) {
			return i;
		}
	}

	return vecA.size()-1;
}

bool areSameReverse(vector<int> vecA, vector<int> vecB) {
	if (vecA.size() != vecB.size())
		return false;

	vector<int>::size_type size = vecA.size();

	for (int i = 0; i < size; i++) {
		if (vecA[i] != vecB[size-1-i]) {
			return false;
		}
	}

	return true;
}