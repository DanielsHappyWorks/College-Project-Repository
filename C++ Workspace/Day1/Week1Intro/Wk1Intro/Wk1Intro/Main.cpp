/*
Create the following in separate mainApps
1.	hello world!

2.	for loop
while loop
do while loop
switch

3.	banner exercise
eg.
/********************/
/*		*                    *		*/
/*		         Tim				*/
/*		*                    *		*/
/*		/********************/

/*
4.	implement methods into banner exercise
*/

//	1. Hello World!

/*
#include <iostream>;													//Include the iostream so we can read the write to and from the comand line
int main()																//The main method
{
std::cout << ("Hello World!");										//Outputs "Hello World!" to the comand line using the cout (pronounced "c out") function in the standard namespace (std).
system("pause");													//Stops the comand line from closing instantly
return 0;															//The main must return and int.   0 means the program worked.  Other numbers mean different errors occured.
}
*/


/*
2. for loop
while loop
do while loop
switch

#include <iostream>;
using std::cout;
using std::endl;														//End the line

int main()
{
//for loop
for (int a = 0; a < 5; a++)
cout << "A";
cout << endl;														//Go to a new line

//while loop
int b = 0;
while (b < 5)
{
cout << "B";
b++;
}
cout << endl;

//do while
int c = 0;
do
{
cout << "C";
c++;
}
while (c < 5);
cout << endl;

//switch
int age = 20;
switch (age)
{
case 10:
age = 10;
cout << "Your age is ten";
break;

case 20:
age = 20;
cout << "Your age is twenty";
break;

case 30:
age = 30;
cout << "Your age is thirty";
break;

default: cout << "You are another age!";
}
cout << endl;

system("pause");
return 0;
}
*/

//	3.	banner exercise
//  eg.
/********************/
/*		*                    *		*/
/*		         Tim				*/
/*		*                    *		*/
/*		/********************/

/*
#include <iostream>;
#include <string>;														//Include string functionality
using std::cout;
using std::endl;
using std::cin;
using std::string;

int main()
{
cout << "What is your name? " << endl;
string name;
cin >> name;														//Assign the user input to the name.  Notice the brackets are going the opposite direction.

//Output first line			/********************/
/*
cout << "/";
for (int a = 0; a < 20; a++)
cout << "*";
cout << "/" << endl;

//Output second line		*                    *

cout << "*";
for (int b = 0; b < 20; b++)
cout << " ";
cout << "*" << endl;

//Output name line			        name

int padding = (20 - name.length()) / 2;								//Find the number of spaces to leave either side of name so that name is in the center.

for (int c = 0; c < padding; c++)									//Output the left padding
cout << " ";

cout << name;														//Output the name

for (int d = 0; d < 20; d++)										//Output the right padding
cout << " ";
cout << endl;

//Output second line		*                    *

cout << "*";
for (int b = 0; b < 20; b++)
cout << " ";
cout << "*" << endl;

//Output first line			/********************/
/*
cout << "/";
for (int a = 0; a < 20; a++)
cout << "*";
cout << "/" << endl;

system("pause");
return 0;
}
*/

//4.	Implement methods into the banner exercise

#include <iostream>;
#include <string>;
using std::cout;
using std::endl;
using std::cin;
using std::string;

void outputHeaderAndFooter();											//All methods have to be declared above the main method
void outputMidleLine();
void outputNameLine(string name);

int main()
{
	cout << "What is your name? " << endl;
	string name;
	cin >> name;

	outputHeaderAndFooter();
	outputMidleLine();
	outputNameLine(name);
	outputMidleLine();
	outputHeaderAndFooter();

	system("pause");
	return 0;
}

void outputHeaderAndFooter()
{
	/********************/
	cout << "/";
	for (int a = 0; a < 20; a++)
		cout << "*";
	cout << "/" << endl;
}

void outputMidleLine()
{
	//*                    *
	cout << "*";
	for (int b = 0; b < 20; b++)
		cout << " ";
	cout << "*" << endl;
}

void outputNameLine(string name)
{
	/*        name         */
	int padding = (20 - name.length()) / 2;

	for (int c = 0; c < padding; c++)
		cout << " ";
	cout << name;

	for (int d = 0; d < 20; d++)
		cout << " ";

	cout << endl;
}