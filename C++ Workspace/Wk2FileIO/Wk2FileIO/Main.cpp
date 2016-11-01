#include <iostream>
#include <fstream>
#include <string>
#include "Main.h"

using namespace std;

void demoFileIO();
void demoMixedType();
double divide(int x, int y);
void demoTryCatch();

int main() {
	//demoFileIO();
	//demoMixedType();
	demoTryCatch();
	system("pause");
	return 0;
}

void demoFileIO() {
	ofstream outFile("data.txt");
	if (outFile) {
		outFile << "Final Fantasy 13 Lightning Returns" << endl;
		outFile << 69.99 << endl;
		outFile << true << endl;
	}
	else {
		cout << "FAILED!!!!" << endl;
	}
	outFile.close();

	ifstream inFile;
	inFile.open("data.txt");
	string data;
	while (!inFile.eof()) {
		inFile >> data;
		cout << data << endl;
	}
}

void demoMixedType() {
	ifstream inFile;
	inFile.open("country.txt");
	string name;
	int year;
	float pop;
	while (!inFile.eof()) {
		inFile >> name;
		inFile >> year;
		inFile >> pop;
		cout << name << "," << year << "," << pop << endl;
	}
}
void demoTryCatch() {
	try{
		cout << divide(10,0) << endl;
	}
	catch (domain_error e) {
		cout << e.what() << endl;
	}
	catch (logic_error e) {

	}
}

double divide(int x, int y) {
	if (y == 0){
		throw new domain_error("Y was zero!");
	}
	else if (x == 0) {
		throw new domain_error("X was zero!");
	}
	else{
		return static_cast<double>(x) / y;
	}
}