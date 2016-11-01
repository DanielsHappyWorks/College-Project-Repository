/*
Name:		Main.cpp
Function:	Class Exercises - Q4 Solution. This solution also includes demo code
illustrating how to add a static count and string array to the DayType class and how to print an array
See:		https://moodle.dkit.ie/201617/mod/url/view.php?id=167116
Author:		NMCG
Version:	1.0
Date:		12/10/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include <iostream>
#include <vector>
#include <algorithm>
#include "DayType.h"

/*************************** Function resolution to a namespace*****************************
********************************************************************************************/
using namespace std;

/******************************* Method declarations ***************************************
********************************************************************************************/
void demoDayType();
void demoDayTypeVector();
void demoStaticVariables();
void demoArrayPrint();

vector<DayType> populate();
void print(string theArray[], int size);
void print(const vector<DayType>& v);
bool compDayTypeByValue(const DayType& d1, const DayType& d2);
bool compDayTypeAlphabetically(const DayType& d1, const DayType& d2);

/******************************************* Main *******************************************
********************************************************************************************/
int main()
{
	cout << "********************** demoDayType **********************" << endl;
	demoDayType();

	cout << "********************** demoDayTypeVector **********************" << endl;
	demoDayTypeVector();

	cout << "********************** demoStaticVariables **********************" << endl;
	demoStaticVariables();

	cout << "********************** demoArrayPrint **********************" << endl;
	demoArrayPrint();

	system("pause");
	return 0;
}

/******************************* Method definitions ****************************************
********************************************************************************************/

/*
Demonstrates how to populate a vector with DayType objects and return a reference to the vector
and sort the vector by two distinct criteria using a comparator function.
*/
void demoDayTypeVector()
{
	//call a populate method
	vector<DayType> v = populate();

	//sort by alphabetic
	sort(begin(v), end(v), compDayTypeAlphabetically);
	print(v);

	//sort by day value (e.g. mon == 0)
	sort(begin(v), end(v), compDayTypeByValue);
	print(v);
}

//returns a vector of DayType objects for ONE week
vector<DayType> populate()
{
	vector<DayType> vectorOut;
	for (int i = 0; i < 7; i++)
		vectorOut.push_back(DayType(i));
	return vectorOut;
}

void print(const vector<DayType>& v)
{
	for (DayType dT : v)
		cout << dT.getAsString() << endl;
}

//compares two DayType objects by value
bool compDayTypeByValue(const DayType& d1, const DayType& d2)
{
	if (d1.getAsValue() < d2.getAsValue())
		return true;
	else
		return false;
}

//compares two DayType objects by alphabetic position of the string e.g. satureday before tuesday
bool compDayTypeAlphabetically(const DayType& d1, const DayType& d2)
{
	if (d1.getAsString().compare(d2.getAsString()) < 0)
		return true;
	else
		return false;
}

void demoDayType()
{
	DayType d1(2);
	d1.print();

	cout << "Get:" << d1.getAsString() << endl;
	cout << "Next:" << d1.next() << endl;
	cout << "Previous:" << d1.previous() << endl;

	DayType twoDaysForward = d1.add(2);
	cout << "Add(2): " << twoDaysForward.getAsString() << endl;

	DayType threeDaysBack = d1.add(-3);
	cout << "Add(-3): " << threeDaysBack.getAsString() << endl;
}

//demonstrates how to access a static method or variable in a class
void demoStaticVariables()
{
	cout << "Count: " << DayType::getCount() << endl;
}

//Demonstrates how to print an array. When we pass an array to a method we must pass the dimension of the array also.
void demoArrayPrint()
{
	print(DayType::dayArray, 7);
}

void print(string theArray[], int size)
{
	for (int i = 0; i < size; i++)
		cout << theArray[i] << endl;
}