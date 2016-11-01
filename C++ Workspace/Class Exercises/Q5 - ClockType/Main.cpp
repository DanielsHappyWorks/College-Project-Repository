/*
Name:		Main.cpp
Function:	Class Exercises - Q5 Solution. This solution also includes demo code	
			illustrating how to overload the string() function and << operator 
See:		https://msdn.microsoft.com/en-us/library/1z2f6c2k.aspx
Author:		NMCG
Version:	1.0
Date:		12/10/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include <iostream>
#include <string>
#include "ClockType.h"

/*************************** Function resolution to a namespace*****************************
********************************************************************************************/

/*
using namespace std;

We can use the pre-compiler directive above to prevent us from having to write std::cout but it's
better practice to qualify the function (e.g. cout) using the namespace (i.e. std::cout).
It doesn't make the code more efficient but it is regarded as a more preferable approach.

*/

/******************************* Method declarations ***************************************
********************************************************************************************/
void demoCustomPrint();
void demoOverloadString();
void demoOverloadOperator();
void demoUsingPrintf();

/******************************************* Main *******************************************
********************************************************************************************/
int main()
{
	std::cout << "*********************** demoUsingPrintf ***********************" << std::endl;
	demoUsingPrintf();

	std::cout << "*********************** demoCustomPrint ***********************" << std::endl;
	demoCustomPrint();

	std::cout << "*********************** demoOverloadString ***********************" << std::endl;
	demoOverloadString();

	std::cout << "*********************** demoOverloadOperator ***********************" << std::endl;
	demoOverloadOperator();

	system("pause");
	return 0;
}

/******************************* Method definitions ****************************************
********************************************************************************************/
void demoCustomPrint()
{
	//uses our custom print method based on printf()
	ClockType c1;
	c1.print("Time: %02d:%02d:%02d\n");
	ClockType c2(9, 30, 45);
	c2.print("%d\t%d\t%d\n");
}

//uses the overloaded string() method
void demoOverloadString()
{
	ClockType c1;
	std::string s = c1; //calls ClockType::string()
	std::cout << s << std::endl;
}

//uses the overloaded << operator
void demoOverloadOperator()
{
	ClockType c1;
	std::cout << c1 << std::endl;
	std::cout << ClockType(12, 30, 0) << std::endl;
}

//demonstrates how to use a C function to allow us greater flexibility on output format
void demoUsingPrintf()
{
	std::cout << "Hello World!!" << std::endl;  //outputting a string in C++
	printf("Hello World!!!\n");					//outputting a string in C
	printf("My age is %d\n", 22);
	printf("The value of pi is %1.3f\n", 3.14159); //1 digit and 3 decimal precision
	printf("100 as octal is %o\n", 100);
	printf("100 as hex is %x\n", 100);
	printf("My first initial is %c\n", 'N');
	printf("%d, %f, %c\n", 12, 3.14159, 'X');
}