#include "Vehicle.h"
#include <iostream>

using namespace std;

Vehicle::Vehicle() 
	: make("def_make"), model("def_model"), 
					passengerCount(1), range(0)
{
}
Vehicle::Vehicle(string make, string model,
	int passengerCount, float range)
	: make(make), model(model),
	passengerCount(passengerCount), range(range)
{
}

Vehicle::~Vehicle()
{

}

void Vehicle::print()
{
	cout << "Vehicle[";
	cout << make << "," << model << ","
		<< passengerCount << "," << range;
	cout << "]";
}