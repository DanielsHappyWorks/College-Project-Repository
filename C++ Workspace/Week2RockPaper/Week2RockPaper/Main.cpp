/*
Name:		Main.cpp
Function:	Demonstrates the use of bitwise operators (i.e. left & right shift, AND and OR)
See:		https://www.tutorialspoint.com/cplusplus/cpp_operators.htm
https://www.tutorialspoint.com/cplusplus/cpp_bitwise_operators.htm
Author:		NMCG
Version:	1.0
Date:		26/9/16
Bugs:		None
*/

/************************************** Includes *******************************************
********************************************************************************************/
#include <iostream>
#include <string>
#include <iterator>


/*************************** Function resolution to a namespace*****************************
********************************************************************************************/
using namespace std;


/******************************* Method declarations ***************************************
********************************************************************************************/
void demoShiftLeftAndRight();
void demoIsBitSet();
void demoBitSet();

int shiftLeft(int value, int shiftBy);
int shiftRight(int value, int shiftBy);
bool isBitSet(int value, int position);
//void setBit(int& value, int position, int isOn);
int setBit(const int& value, const int& position, const bool& isOn);
void demoGame();
int showOptionsGetChoice(string optionArray[]);

/******************************************* Main *******************************************
********************************************************************************************/
int main()
{
	/*
	cout << "*********************** demoShiftLeftAndRight ***********************" << endl;
	demoShiftLeftAndRight();

	cout << "*********************** demoIsBitSet ***********************" << endl;
	demoIsBitSet();

	cout << "*********************** demoBitSet ***********************" << endl;
	demoBitSet();
*/
	demoGame();
	system("pause");
	return 0;
	
	
}

void demoGame() {
	string optionArray[] = { "Rock", "Paper","Scissors", "Lizard", "Sopck" };
	int nodeValueArray[] = { 12,17,10,18,5 };
	//present imput options player 1
	int player1choice = showOptionsGetChoice(optionArray);
	//get imput value player 1
	int encodedValue = nodeValueArray[player1choice];
	//present imput options player 2
	int player2choice = showOptionsGetChoice(optionArray);
	//if choice identical then draw
	//convert player 2 value to its node number (1-4)
	//quert player 1 value with node number
	//if bit is set to 1 then player 2 wins
	//else player 1 wins
	if (player1choice == player2choice) {
		cout << "Draw" << endl;
	}
	else {
		if(isBitSet(encodedValue, player2choice)){
			cout << "P2 wins" << endl;
		}
		else {
			cout << "P1 wins" << endl;
		}
	}
}

int showOptionsGetChoice(string optionArray[]) {
	int choice;
	cout << "Please enter a number for the option below: " << endl;
	cout << "********************************************" << endl;

	//for (string* s = begin(optionArray); s != end(optionArray); s++) {
	//	cout << *s << endl;
	//}

	for (int i = 0; i < 5; i++) {
		cout << optionArray[i] << endl;
	}
	cin >> choice;
	return choice-1;
}

/******************************* Method definitions ****************************************
********************************************************************************************/
void demoShiftLeftAndRight()
{
	int value = 1;
	for (int i = 0; i <= 8; i++)
	{
		cout << value << " shifted left by " << i << " bits is " << shiftLeft(value, i) << endl;
	}

	value = 256;
	for (int i = 0; i <= 8; i++)
	{
		cout << value << " shifted right by " << i << " bits is " << shiftRight(value, i) << endl;
	}
}
void demoIsBitSet()
{
	int value = 218; //some random value => binary = 11011010
	cout << "218 in binary is 11011010 - are the bits set?" << endl;

	for (int i = 7; i >= 0; i--)
	{
		cout << "Bit[" << i << "] of " << value << " set:" << isBitSet(value, i) << endl;
	}
}

//sets the bit at positions 0, 1, 2, 3 i.e. 00000000, 00000001, 00000011, 00000111
void demoBitSet()
{
	int value = 0, result = 0;
	for (int i = 0; i < 8; i++)
	{
		result = setBit(value, i, true);
		cout << "Setting bit[" << i << "] gives " << result << endl;
	}
}

//essentially a multiply by 2 
int shiftLeft(int value, int shiftBy)
{
	return value << shiftBy;
}
//essentially a divide by 2 and drop remainder (e.g. for value = 7 and shiftBy = 1, result = 3)
int shiftRight(int value, int shiftBy)
{
	return value >> shiftBy;
}

//tests to see if a bit is set
bool isBitSet(int value, int position)
{
	int mask = 1 << position;
	if ((mask & value) > 0)
		return true;
	else
		return false;
}

//set a particular bit - notice how we pass value by reference so we can change the original value
/*void setBit(int& value, int position, bool isOn)
{
	int mask = 1 << position;
	if(!isOn){//set to 0 w.g 1011
		mask = ~mask;
	}
	value = value | mask;
}
*/
int setBit(const int& value, const int& position, const bool& isOn)
{
	int mask = 1 << position;
	if (!isOn) {//set to 0 w.g 1011
		mask = ~mask;
	}
	return value | mask;
}