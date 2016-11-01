#include <iostream>

using namespace std;
void demoPointerArray();
void demoPointerOperators1();
void demoPointerOperators2();
void demoPointerOperators3();

struct Account
{
	int id; //4
	float balance; //4
	bool isCurrent; //1 could be padded to 4?
};

int main() {
	//Pointer - domain - all memory adresses in RAM
	int a = 10;
	int* b = nullptr; //NULL became nullptr in C++ 11 - future proof
	b = &a;

	//demoPointerArray();
	//demoPointerOperators1();
	//demoPointerOperators2();
	demoPointerOperators3();

	system("pause");
	return 0;
}

void demoPointerOperators3() {
	Account a1;
	a1.id = 0;
	a1.balance = 150;
	a1.isCurrent = true;

	Account a2;
	a2.id = 0;
	a2.balance = 150;
	a2.isCurrent = true;

	Account* pAcc;
	pAcc = &a1;

	pAcc->id = 202;
	pAcc->balance = 1000;
	(*pAcc).isCurrent = false; //precursor tech

	cout << sizeof(int) << endl;
	cout << sizeof(float) << endl;
	cout << sizeof(bool) << endl;
	cout << sizeof(a1) << endl;
	cout << sizeof(pAcc) << endl;
	cout << sizeof(*pAcc) << endl;

	Account* pAccArray = new Account[2];
	pAccArray[0] = a1;
	pAccArray[1] = a2;

	cout << pAccArray << endl;
	cout << (pAccArray+1) << endl;

	delete pAcc;
	pAcc = nullptr;
	delete[] pAccArray;
	pAccArray = nullptr;
}

void demoPointerOperators2() {
	//make an array of doubles with 3 elements 
	//print address and value using + operator

	double *pArray = new double[3];
	pArray[0] = 45.54;
	pArray[1] = 894.4984;
	pArray[2] = 94.984;

	cout << pArray << endl;
	cout << *pArray << endl;

	cout << (pArray+1) << endl;
	cout << *(pArray + 1) << endl;

	cout << (pArray + 2) << endl;
	cout << *(pArray + 2) << endl;

	//pArray += 1; //prints but breaks cause it cant be modified // A pointer is a constant pointer to the base address
	//cout << pArray << endl;
	//cout << *pArray << endl;

	int diff = ((pArray + 1) - pArray) * sizeof(*pArray);
	cout << "Size Difference: " << diff << endl;

	int sizeOf = sizeof(pArray);
	cout << "SizeOF pArray: " << sizeOf << endl;

	delete[] pArray;
	pArray = nullptr;
}



void demoPointerOperators1() {
	//+,-,++,--,==, !=, >, < etc
	int a = 20;
	int* b = &a; // b is a pointer to an integer a
	int* c = &a;

	if (b == c) {
		cout << "Same" << endl;
	}

	if (b != c) {
		cout << "Different" << endl;
	}

	int* pArray = new int[3];
	pArray[0] = 5;
	pArray[1] = 15;
	pArray[2] = 25;

	cout << pArray << endl;
	cout << *pArray << endl;
	cout << (pArray+1) << endl;
	cout << *(pArray + 1) << endl;

	delete[] pArray;
	pArray = nullptr;
}

void demoPointerArray() {
	int size;
	cout << "Enter array size: " << endl;
	cin >> size;
	int* pArray = new int[size]; //cant demension an array after compile time unless you use a pointer

	for (int i = 0; i < size; i++) {
		cout << "Enter element " << i << ": " << endl;
		cin >> pArray[i];
	}
	//sum and output the sum of ints

	int sum = 0;

	for (int i = 0; i < size; i++) {
		sum += pArray[i];
	}

	cout << "The Sum is: " << sum << endl;

	//housekeeping
	//what is the value before its freed
	cout << "Before: " << pArray << endl;
	delete[] pArray; // if we dont relese memory we can cause a memory leak
					 //what is the value after its freed
	cout << "After: " << pArray << endl;
	//if we dont want a "dangling pointer" then we set to null 0 or nullptr
	pArray = nullptr;
	cout << "After: " << pArray << endl;
}



/*
void dummyMethod(int* &x);
int main() {
	
	int x = 10;
	int* y = &x; // pointer that takes the address in ram

	char s = 'D';
	char* t = &s;

	cout << y << endl;
	cout << *t << endl; //de reference the value 

	*t = 'K'; //changes what the value points to

	cout << s << endl;
	cout << *t << endl;
	
	int a = 100;
	int* b = &a;
	
	dummyMethod(b);

	cout << *b << endl;

	system("pause");
	return 0;

}
void dummyMethod(int* &x) {//needs to be passed by reference to change
	int z = 999;
	x = &z;
}
*/