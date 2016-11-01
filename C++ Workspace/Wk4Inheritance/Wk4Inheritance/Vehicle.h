//#pragma once
#include <string>
class Vehicle
{
public:
	Vehicle();
	Vehicle(std::string make, std::string model,
					int passengerCount, float range);
	~Vehicle();
	void print();
	
	std::string getMake() const { return make; }
	std::string getModel() const { return model; }
	int getPassengerCount() const { return passengerCount; }
	float getRange() const { return range; }
	void setMake(std::string make) { Vehicle::make = make; }
	void setModel(std::string model) { Vehicle::model = model; }
	void setPassengerCount(int passengerCount) { Vehicle::passengerCount = passengerCount; }
	void setRange(float range) { Vehicle::range =  range; }
	
private:
	std::string make, model;
	int passengerCount;
	float range;

protected:
	int dummy; //accessible to child classes only
};
