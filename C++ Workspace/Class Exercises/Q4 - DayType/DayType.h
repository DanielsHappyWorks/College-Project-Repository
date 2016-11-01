#include <string>

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
	DayType add(int add);

	int getAsValue() const { return value; }
	std::string getAsString() const { return dayArray[value]; }

	static int getCount() { return count; }
	static std::string dayArray[7]; //a shared static variable which allows us to convert value to string

private:
	int value;
	static int count; //counts the number of DayType objects currently in the system
};