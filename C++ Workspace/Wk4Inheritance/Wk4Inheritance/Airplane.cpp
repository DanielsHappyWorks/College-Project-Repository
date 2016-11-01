#include <iostream>
#include "Airplane.h"
using namespace std;

Airplane::Airplane() 
: Vehicle("def_make", "def_model", 1, 0),
				flightCeiling(0)
{
}
Airplane::Airplane(string make, string model,
	int passengerCount, float range, float flightCeiling)
	: Vehicle(make, model, passengerCount, range), 
	flightCeiling(flightCeiling)
{
	//Airplane::flightCeiling = flightCeiling;
}

Airplane::~Airplane()
{

}

void Airplane::print()
{
	cout << "Airplane[";
	Vehicle::print();
	cout << "," << flightCeiling;
	cout << "]";
}