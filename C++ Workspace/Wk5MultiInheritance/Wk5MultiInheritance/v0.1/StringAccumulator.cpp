#include <iostream>
#include "StringAccumulator.h"
using namespace std;

StringAccumulator::StringAccumulator(string id) : id(id)
{
	reset();
}

StringAccumulator::~StringAccumulator()
{
}

void StringAccumulator::reset()
{
	largestLength = 0; //it's an unsigned int so cant be -1
	largestString = "";
	count = 0;
	sum = 0;
}
void StringAccumulator::process(string data)
{
	int length = data.length();
	if (length > largestLength)
	{
		largestLength = length;
		largestString = data;
	}
	count++;
	sum += length;
}
void StringAccumulator::print()
{
	cout << "Largest:" << largestString
		<< ", Average:" << getAverage()
		<< "Count:" << count;
}
