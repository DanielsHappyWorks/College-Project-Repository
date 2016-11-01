#include <iostream>
#include <string>
#include <vector>

using namespace std;

void demoStudentStruct();


struct Student{
	string name;
	int CA, exam;
};

void print(const Student& s);
void print(const vector<Student>& v);
int search(const vector<Student>& v, string name, int CA, int exam);
void removeAll(vector<Student>& v, string name);
Student operator+(const Student& a, const Student& b);

int main() {
	demoStudentStruct();
	system("pause");
	return 0;
}

void demoStudentStruct() {
	Student s1;
	s1.name = "Daniel Foth";
	s1.CA = 85;
	s1.exam = 88;

	Student s4 = s1;

	Student s5 = s1;

	Student s6 = s1;

	Student s2 = s1;
	s2.name = "Peter Fitz";

	Student s3;
	s3.name = "Niall";
	s3.CA = 100;
	s3.exam = 100;

	Student s7;
	s7.name = "Dan";
	s7.CA = 90;
	s7.exam = 90;

	Student s8 = s7 + s3;

	vector<Student> v1 = { s1,s2,s3,s4,s5,s6,s7,s8 };
	int isIn = search(v1,"Dan",90,90);
	cout << "Is Dan in:" << isIn << endl;
	isIn = search(v1, "Marta", 90, 90);
	cout << "Is Marta in:" << isIn << endl;
	removeAll(v1, "Daniel Foth");
	print(v1);
}

void print(const Student& s) {
	cout << "Name: " << s.name << ", CA: " << s.CA << ", Exam: " << s.exam << endl;
}

void print(const vector<Student>& v) {
	for (int i = 0; i < v.size(); i++) {
		print(v[i]);
		
	}
}

int search(const vector<Student>& v, string name, int CA, int exam) {
	int i = 0;
	for (Student s : v) {
		if (name == v[i].name && CA == v[i].CA && exam == v[i].exam) {
			return i;
		}
		i++;
	}
	return -1;
}

void removeAll(vector<Student>& v, string name) {
	for (int i = 0; i < v.size(); i++) {
		if (name == v[i].name) {
			v.erase(v.begin() + i);
			i--;
		}
	}
}

bool operator==(const Student& a, const Student& b) {
	return (a.name == b.name) && (a.CA == b.CA) && (a.exam == b.exam);
}

bool operator!=(const Student& a, const Student& b) {
	return !(a == b);
}

Student operator+(const Student& a, const Student& b) {
	Student out;
	out.name = a.name +":"+ b.name;
	out.CA = a.CA + b.CA;
	out.exam = a.exam + b.exam;
	return out;
}