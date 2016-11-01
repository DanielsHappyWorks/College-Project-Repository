/*
Name:		Main.cpp
Function:	Demonstrates how to inherit from a single class.
See:		https://www.tutorialspoint.com/cplusplus/cpp_inheritance.htm
			CA1 - Pair Project
			http://www.cplusplus.com/doc/tutorial/polymorphism/ (dont worry about this link yet)
Author:		NMCG
Version:	1.0
Date:		14/10/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include <iostream>
#include <vector>
#include "Airplane.h"

/*************************** Function resolution to a namespace*****************************
********************************************************************************************/
using namespace std;

/******************************* Method declarations ***************************************
********************************************************************************************/
//None

/******************************************* Main *******************************************
********************************************************************************************/
int main()
{
	Vehicle v1("ford", "focus", 5, 1000);
	Airplane a1("Cessna", "208", 12, 25000, 1996);
	Airplane a2("boeing", "737", 137, 5000, 10200);


	cout << "*********************** Print ***********************" << endl;
	//calling the print method
	v1.print();
	cout << endl;
	a1.print();
	cout << endl;

	cout << "*********************** Polymorphism I ***********************" << endl;
	//polymorphism
	Vehicle v2 = a1;
	v2.print(); //will the correct print method be called? no. we need pointers and virtual!
	cout << endl;

	cout << "*********************** Polymorphism II ***********************" << endl;
	//how we can add mixed types to a vector
	vector<Vehicle> myVehicleVector;
	myVehicleVector.push_back(v1);
	myVehicleVector.push_back(a1);
	myVehicleVector.push_back(a2);
	
	for (Vehicle v : myVehicleVector)
	{
		v.print(); //will the correct print method be called? no. we need pointers and virtual!
		cout << endl;
	}

	system("pause");

	return 0;
}

/******************************* Method definitions ****************************************
********************************************************************************************/
//None