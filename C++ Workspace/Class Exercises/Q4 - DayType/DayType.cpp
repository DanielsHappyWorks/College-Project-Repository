#include "DayType.h"

using namespace std;

int DayType::count = 0;
string DayType::dayArray[7] = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };

DayType::DayType(int value) //: value(value)
{
	//some validation
	if ((value >= 0) && (value <= 6))
		DayType::value = value; //notice how we need to use DayType:: to resolve the left hand value
	else
		DayType::value = 0;

	DayType::count++;
}
DayType::~DayType()
{
	DayType::count--;
}
void DayType::print()
{
	cout << "Value: " << value << endl;
}
string DayType::next()
{
	return nextDay().getAsString();
}
string DayType::previous()
{
	return previousDay().getAsString();
}
DayType DayType::add(int add) 
{
	int temp = value;

	if (add > 0) //wrap forwards
	{
		temp += add;
	}
	else //wrap backwards
	{
		add %= 7; //i.e. -18 is same as -11 is the same as -4 etc
		temp += add; //subtract from current value, remember add is < 0
		temp += 7;   //whatever is left subtract from 7
	}

	temp %= 7; //prevent over-flow 
	return DayType(temp);
	//add is negative?
}
DayType DayType::nextDay()
{
	return add(1);
}
DayType DayType::previousDay()
{
	return add(-1);
}