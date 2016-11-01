#include "Student.h"
#include <iostream>

using namespace std;

Student::Student(string name, int ca, int exam)
	:name(name), ca(ca), exam(exam)
{
}

Student::~Student()
{
}

void Student::print() {
	cout << "Name: " << name << endl;
	cout << "Ca: " << ca << endl;
	cout << "Exam: " << exam << endl;
}