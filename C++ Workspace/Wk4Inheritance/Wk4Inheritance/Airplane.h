#include "Vehicle.h"

class Airplane : public Vehicle
{
public:
	Airplane();
	Airplane(std::string make, std::string model,
		int passengerCount, float range,
		float flightCeiling);
	~Airplane();
	float getFlightCeiling() const { return flightCeiling; }
	void setFlightCeiling(float flightCeiling) { Airplane::flightCeiling = flightCeiling; }
	void print();
private:
	float flightCeiling;
protected:
	//not using this
};