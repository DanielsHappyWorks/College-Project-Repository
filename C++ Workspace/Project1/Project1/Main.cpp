/*
Name:		Main.cpp
Function:	Demonstrates the use of an Iterator and common vector methods including pushback and insert.
See:		http://www.cplusplus.com/reference/vector/vector/
http://www.cplusplus.com/reference/vector/vector/insert/
Author:		NMCG
Version:	1.0
Date:		3/10/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include <iostream>
#include <string>
#include <vector>

/*************************** Function resolution to a namespace*****************************
********************************************************************************************/
using namespace std;

/******************************* Method declarations ***************************************
********************************************************************************************/
void demoVectorIteration();
void demoVectorUsingIterator();
void demoVectorUsingInsertToFill();
void demoVectorUsingInsertToInitialize();

void print(const vector<string>& strVector, string prompt);
void print(const vector<int>& strVector, string prompt);

/******************************************* Main *******************************************
********************************************************************************************/
int main()
{
	cout << "*********************** demoVectorIteration ***********************" << endl;
	demoVectorIteration();

	cout << "*********************** demoVectorUsingInsert ***********************" << endl;
	demoVectorUsingIterator();

	cout << "*********************** demoVectorUsingInsertToFill ***********************" << endl;
	demoVectorUsingInsertToFill();

	cout << "*********************** demoVectorUsingInsertToInitialize ***********************" << endl;
	demoVectorUsingInsertToInitialize();

	system("pause");
	return 0;
}

/******************************* Method definitions ****************************************
********************************************************************************************/
void demoVectorIteration()
{
	vector<double> grades = { 45, 78, 32, 90, 40, 78 }; //another way to add contents to a vector vs. push_back()

														//Standard for loop
	cout << "Standard for loop..." << endl;
	vector<double>::size_type size = grades.size();
	for (int i = 0; i < size; i++)
	{
		cout << grades[i] << endl;
	}


	//Ranged for loop
	cout << "Ranged for loop..." << endl;
	for (double grade : grades)
	{
		cout << grade << endl;
	}

	//Iterator based loop
	cout << "Iterator based loop..." << endl;
	for (vector<double>::iterator iter = begin(grades); iter != end(grades); iter++)
	{
		cout << *iter << endl; //the * dereferences the pointer (i.e. it gets the value "pointed to" by iter)
	}
}

void demoVectorUsingIterator()
{
	cout << "In the example below notice that the position of the iterator BEFORE and AFTER an insert is the same..." << endl;

	vector<string> colorVector;
	colorVector.push_back("red");
	//orange
	colorVector.push_back("yellow");
	colorVector.push_back("green");
	colorVector.push_back("indigo");
	colorVector.push_back("violet");

	print(colorVector, "Initial contents...");

	vector<string>::iterator iter = begin(colorVector);		//iter points to red
	iter++;													//iter points to yellow
	colorVector.insert(iter, "orange");						//after insert iter points to orange

	string prompt = "After pushing orange...";
	
	print(colorVector, prompt);

	iter += 3;												//iter points to indigo
	colorVector.insert(iter, "blue");						//after insert iter points to blue
	colorVector.insert(iter, "Daniel");

	string prompt1 = "After pushing blue...";
	print(colorVector, prompt1);

}

void demoVectorUsingInsertToFill()
{
	vector<int> numberVectorA = { 1, 2, 3, 4, 5, 6 };
	vector<int> numberVectorB = { 7, 8, 9, 10 };

	vector<int>::iterator iterA = end(numberVectorA);

	//add all (i.e. begin to end) of numberVectorB to numberVectorA starting from the end of numberVectorA
	numberVectorA.insert(iterA, begin(numberVectorB), end(numberVectorB));

	print(numberVectorA, "Using insert to combine two vectors...");
}

void demoVectorUsingInsertToInitialize()
{
	vector<int> playerHealthVector;

	playerHealthVector.insert(begin(playerHealthVector), 5, 100);

	print(playerHealthVector, "Using insert to set initial player health for 5 players...");
}

//why do we use const and &? It's good coding practice and makes our methods execute faster - since we are not passing by copy
void print(const vector<string>& strVector, string prompt)
{
	cout << prompt << endl;
	for (string str : strVector)
	{
		cout << str << endl;
	}
}

//you can see that having to overload this method for each data type is NOT ideal. we need generics!
void print(const vector<int>& strVector, string prompt)
{
	cout << prompt << endl;
	for (int n : strVector)
	{
		cout << n << endl;
	}
}
/*
vector<int> interleave(vector<int> a, vector<int> b)
{
	if (a.size() != b.size())
		return nullptr;

}*/