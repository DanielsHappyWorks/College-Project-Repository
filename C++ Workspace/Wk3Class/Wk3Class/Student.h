#include<string>

//using namespace std;
class Student {
public:
	Student(std::string name, int ca, int exam);
	~Student();
	void print();

private:
	std::string name;
	int ca, exam;
};