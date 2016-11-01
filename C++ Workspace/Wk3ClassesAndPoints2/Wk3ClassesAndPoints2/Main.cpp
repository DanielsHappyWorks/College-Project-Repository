#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include "Point2D.h"
#include "DayType.h"
using namespace std;

void demoDayType();
void demoPoint2D();
Point2D add(const Point2D& p1, const Point2D& p2);
void demoDayTypeVector();
vector<DayType> populate();
void print(const vector<DayType>& v);
vector<DayType> populate();
bool compDayType(const DayType& d1, const DayType& d2);
bool compDayTypeLex(const DayType& d1, const DayType& d2);
void print(int array[], int size);


int main()
{
	//tic tac toe
	int ticTacToe[3][3]
		= { { 1, 2, 3 },
		{ 4, 5, 6 },
		{ 7, 8, 9 } };

	cout << ticTacToe[0][2] << endl;

	cout << "********************** demoPoint2D **********************" << endl;
	demoPoint2D();

	cout << "********************** demoDayType **********************" << endl;
	demoDayType();

	cout << "********************** demoDayTypeVector **********************" << endl;
	//demoDayTypeVector();

	cout << "Count: " << DayType::getCount() << endl;

	int size = sizeof(DayType::dummyArray) / sizeof(DayType::dummyArray[0]);

	print(DayType::dummyArray, size);

	system("pause");
	return 0;
}

void demoDayTypeVector()
{
	//call a populate method
	vector<DayType> v = populate();

	//sort by alphabetic
	sort(begin(v), end(v), compDayTypeLex);
	print(v);

	//sort by day length as string
	sort(begin(v), end(v), compDayType);
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

bool compDayType(const DayType& d1, const DayType& d2)
{
	if (d1.getAsValue() < d2.getAsValue())
		return true;
	else
		return false;
}

bool compDayTypeLex(const DayType& d1, const DayType& d2)
{
	return d1.getAsString().compare(d2.getAsString());
}


void demoDayType()
{
	DayType d1(2);
	d1.print();

	cout << "Get:" << d1.getAsString() << endl;
	cout << "Next:" << d1.next() << endl;
	cout << "Previous:" << d1.previous() << endl;
	cout << "Add(2): " << d1.add(2) << endl;
	cout << "Add(-1): " << d1.add(-1) << endl;
	cout << "Add(-2): " << d1.add(-2) << endl;
	cout << "Add(-3): " << d1.add(-3) << endl;
	cout << "Add(-4): " << d1.add(-4) << endl;
	cout << "Add(-5): " << d1.add(-5) << endl;
	cout << "Add(-6): " << d1.add(-6) << endl;
	cout << "Add(-7): " << d1.add(-7) << endl;
	cout << "Add(-21): " << d1.add(-21) << endl;
}

void demoPoint2D()
{
	Point2D p1;
	Point2D p2(10, 50);
	Point2D p3(100, 200);

	cout << "Before..." << endl;
	{
		Point2D p8;
	}
	cout << "After..." << endl;

	p1.print();
	p2.print();

	Point2D pOut = add(p1, p2);
	pOut.print();

	Point2D p4 = p2 + p3;
	p4.print();
	Point2D p5 = p2 * p3;
	p4.print();

	if (p4 == p5)
		cout << "p4 and p5 are same!" << endl;
	else
		cout << "p4 and p5 are different!" << endl;
}

Point2D add(const Point2D& p1, const Point2D& p2)
{
	Point2D pOut;
	pOut.setX(p1.getX() + p2.getX()); 
	pOut.setY(p1.getY() + p2.getY());
	return pOut;
}

void print(int array[], int size) {
	for (int i = 0; i < size; i++)
	{
		cout << array[i] << endl;
	}
}