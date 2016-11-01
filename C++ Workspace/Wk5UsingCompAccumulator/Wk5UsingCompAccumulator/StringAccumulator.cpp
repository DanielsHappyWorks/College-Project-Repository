#include <iostream>
#include "StringAccumulator.h"
#include <algorithm>
#include <cmath>

using namespace std;

StringAccumulator::StringAccumulator()
{
	reset();
}

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
	largestLength = 0;
}
void StringAccumulator::process(string data)
{
	int length = data.length();
	if (length > largestLength)
	{
		largestLength = length;
		largestString = data;
	}
	lengthVector.push_back(length);
}

float StringAccumulator::getAverage() {
	float sum = 0;
	for (unsigned int lenght : lengthVector)
		sum += lenght;

	return sum / lengthVector.size();
}

void StringAccumulator::print()
{
	cout << "Largest: " << largestString
		<< ", Average: " << getAverage()
		<< ", Count: " << lengthVector.size() << endl;
}

float StringAccumulator::getMedian() {
	sort(begin(lengthVector), end(lengthVector));

	unsigned int size = lengthVector.size();
	float median = 0;
	if (size % 2 == 0) {
		median = (lengthVector[size / 2] + lengthVector[(size / 2) - 1]) / 2.0;
	}
	else {
		median = lengthVector[static_cast<unsigned int>(size) / 2];
	}
	return median;
}

float StringAccumulator::getStandardDeviation() {

	float average = getAverage();
	float sum = 0;

	for (unsigned int currentLenght : lengthVector) {
		sum += pow(currentLenght - average,2);
	}

	sum /= lengthVector.size();
	return sqrt(sum);

	return sum;
}