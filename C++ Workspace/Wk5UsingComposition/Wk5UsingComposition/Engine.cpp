#include "Engine.h"
using namespace std;

Engine::Engine() : cc(1000), weight(200), type(0) {

}
Engine::Engine(int cc, float weight, int type) : cc(cc), weight(weight), type(type) {

}
Engine::~Engine() {

}

void Engine::print() const {
	cout << Engine::to_string() << endl;
}

bool Engine::operator==(const Engine& other) {
	return (getCC() == other.getCC())
		&& (getWeight() == other.getWeight())
		&& (getType() == other.getType());
}

string Engine::to_string() const {
	return "CC: " + std::to_string(Engine::cc) +
		", Weight: " + std::to_string(Engine::weight) +
		", Type: " + std::to_string(Engine::type);
}

Engine::operator std::string() const {
	return "CC: " + std::to_string(Engine::cc) +
		", Weight: " + std::to_string(Engine::weight) +
		", Type: " + std::to_string(Engine::type);
}

//friend ostream& operator<<(ostream& steam, Engine& engine) {

//}