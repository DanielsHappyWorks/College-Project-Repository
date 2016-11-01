/*
Name:		Main.cpp
Function:	Demonstrates how to implement multiple inheritance to combine the attributes and behaviour of two entities.
See:		http://www.cprogramming.com/tutorial/multiple_inheritance.html
Author:		NMCG
Version:	1.0
Date:		21/10/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include "StringStoreAccumulator.h"
#include <string>
#include <iostream>


/*************************** Function resolution to a namespace*****************************
********************************************************************************************/
using namespace std;

/******************************* Method declarations ***************************************
********************************************************************************************/
int main()
{
	StringAccumulator sAcc("sAcc1");
	string a = "alaska";
	sAcc.process(a);
	sAcc.print();

	a = "afghanistan";
	sAcc.process(a);
	sAcc.print();

	a = "belgium";
	sAcc.process(a);
	sAcc.print();

	StringStoreAccumulator ssAcc("ssAcc1");
	ssAcc.add("france");
	ssAcc.add("germany");
	ssAcc.add("poland");
	ssAcc.add("ireland");

	ssAcc.print();
	
	system("pause");
	return 0;
}