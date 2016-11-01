#include "Engine.h"

class Vehicle
{
public:
	static bool compareByEngineCC(const Vehicle& v1, const Vehicle& v2);
	Vehicle();
	Vehicle(std::string make, Engine engine);
	~Vehicle();
	void print()const;
	bool operator==(const Vehicle& other);

	std::string getMake() const { return make; }
	Engine getEngine() const { return engine; }

private:
	std::string make;
	Engine engine;
};