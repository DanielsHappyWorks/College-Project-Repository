#include <iostream>
#include <string>
#include "ClockType.h"

ClockType::ClockType() : ClockType(9,0,0)
{

}

ClockType::ClockType(int hours, int mins, int seconds)
: hours(hours), mins(mins), seconds(seconds)
{

}

ClockType::~ClockType()
{

}

void ClockType::print(const char* format)
{
	//std::cout << hours << ":" << mins << ":" << seconds << std::endl;
	printf(format, hours, mins, seconds);
}

ClockType::operator std::string() const
{
	/*
	If we wish to form a string from non-string types (e.g. int, float)
	then we need to "string-ify" these value by converting them individually
	to a string using the to_string function of the <string> library
	*/
	return std::to_string(hours)
		+ ":" + std::to_string(hours)
		+ ":" + std::to_string(seconds);
}

std::ostream& operator<<(std::ostream& outStream, ClockType& clockType)
{
	/*
	Notice that we're able to say clockType.hours or clockType.getHours() since
    friend functions can access the classes private member variables and functions
	*/
	outStream << clockType.hours << ":"
		<< clockType.mins << ":"
		<< clockType.seconds;
				
	return outStream;
}

