#include <iostream>
#include "CPPConstants.h"
class DayType
{
public:
	DayType(std::string valueAsStr);
	DayType(int value);
	~DayType();
	void print();
	std::string next();
	std::string previous();

	DayType nextDay();
	DayType previousDay();

	std::string add(int add);
	int getAsValue() const { return value; }
	std::string getAsString() const { return dayArray[value]; }
	static int getCount() { return count; }

	static int dummyArray[3];
private:
	int value;
	static int count;

	//demo dummy array
	
};