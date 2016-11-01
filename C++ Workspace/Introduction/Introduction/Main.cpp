#include <iostream>
#include <string>

using namespace std;

inline double divide(int x=10, int y=2);//x and y has a default parameter
double circleArea(int radius, const double pi);
double cylinderVolume(int& radius, int& height, const double pi);
void add(int& x, int& y, int& result);

int main() {

	//uses default parameters
	cout << "Default parameters: " << divide() << endl;

	//creating a method and casting
	cout << "Start...";
	int x = 8, y = 3;
	double z = divide(x, y);
	cout << "Divide result: " << z << endl;

	//creating a constant
	const double pi = 3.14259; 
	int r = 1;
	cout << "The Area of a circle is: " << circleArea(r,pi) << endl;

	//creating a mothod that takes references
	int height = 5;
	cout << "The Area of a cylinder is: " << cylinderVolume(r, height ,pi) << endl;
	
	//creating a mothod to show that variables change outside of a method if they are references
	int a = 10, b = 15;
	int result;
	add(a, b, result);
	cout << "10 + 15 = " << result << endl;

	system("pause");
	return 0;
}

inline double divide(int x, int y) {
	//inline copies code into where the method is called
	//inilne is for shot and simplistic code that is used over and over again
	//better cast then (double)
	return static_cast<double>(x) / y;
}

double circleArea(int radius, const double pi) {
	//pi cant be changed cause its constant = const
	//constant changes when passed in as a copy 
	return radius * radius * pi;
}

double cylinderVolume(int& radius, int& height, const double pi) {
	//passing radius and height as reference = &
	//faster by insignificant amounts of time unless done over and over
	//if height or radius is changed the change persists
	return pi*radius*radius*height;
	
}

void add(int& x, int& y, int& result) {
	//shows how passing by references changes variables outside of the method
	//save time
	//"return" multiple values from method

	result = x + y;
}


