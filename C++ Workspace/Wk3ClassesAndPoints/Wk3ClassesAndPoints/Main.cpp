#include <iostream>
#include "Point2D.h"

void demoPoint2D();
using namespace std;

int main() {
	//demoPoint2D();
	system("pause");
	return 0;
}

void demoPoint2D() {
	Point2D p1(10, 50);
	p1.print();

	Point2D p2;
	p2.print();

	Point2D p3(6,9);
	p2.print();

	Point2D p4;
	cout << endl;
	cout << "Adding: " << endl;
	p4 = p1 + p3;
	p4.print();
	cout << "Multiplying: " << endl;
	p4 = p1 * p3;
	p4.print();
	cout << "Dividing: " << endl;
	p4 = p1 / p3;
	p4.print();
	cout << "Subtracting: " << endl;
	p4 = p1 - p3;
	p4.print();
	cout << "Multiple: " << endl;
	//operator precedence is still applied
	p4 = p3*p1 - p3/p1;
	p4.print();

	if (p1 == p2) {
		cout << "Equal" << endl;
	}

	if (p1 != p2) {
		cout << "Not Equal" << endl;
	}


}