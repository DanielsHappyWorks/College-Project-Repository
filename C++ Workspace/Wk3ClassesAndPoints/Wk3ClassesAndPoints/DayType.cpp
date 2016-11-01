#include "DayType.h"
#include <iostream>

using namespace std;

DayType::DayType(int value) {

}
DayType::~DayType() {

}
void DayType::print() {
	cout << "Value:" << endl;
}
int DayType::next() {
	value++;
	value %= 7;
	return value;
}
int DayType::previous() {
	value--;
	value = (value < 0) ? 6 : value;
	return value;
}
int DayType::add(int add) {
	value += add;
	value %= 7;
	return value;
}