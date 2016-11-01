#include "Vehicle.h"
#include <string>
using namespace std;
Vehicle::Vehicle() : make(), engine()
{

}
Vehicle::Vehicle(string make, Engine engine) : make(make), engine(engine)
{

}
Vehicle::~Vehicle() {

}
void Vehicle::print() const {
	cout << "Make: " << make << ", " << endl;
	engine.print();
}
bool Vehicle::operator==(const Vehicle& other) {
	return (getMake() == other.getMake())
		&& (getEngine() == other.getEngine());
}

bool Vehicle::compareByEngineCC(const Vehicle& v1, const Vehicle& v2) {
	if (v1.getEngine().getCC() <= v2.getEngine().getCC())
		return true;
	else
		return false;
}
