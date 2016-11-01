#include "Vehicle.h"
#include <vector>
#include <algorithm>

using namespace std;
int main() {
	vector<Vehicle> vec;

	Engine e1(3200, 120, 0);
	Vehicle v1("triump triple r", e1);
	vec.push_back(v1);

	Engine e2(1600, 180, 0);
	Vehicle v2("Kawasaki ninja", e2);
	vec.push_back(v2);

	sort(begin(vec), end(vec), Vehicle::compareByEngineCC);

	for (Vehicle v : vec) {
		v.print();
	}

	system("pause");
	return 0;
}

