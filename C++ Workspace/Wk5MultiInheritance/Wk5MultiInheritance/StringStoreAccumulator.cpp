#include "StringStoreAccumulator.h"
using namespace std;

StringStoreAccumulator::StringStoreAccumulator(string id) 
		: StringStore(id), StringAccumulator(id)
{
}


StringStoreAccumulator::~StringStoreAccumulator()
{
}

void StringStoreAccumulator::add(string s) {
	StringStore::add(s);
	StringAccumulator::process(s);
}

void StringStoreAccumulator::print() {
	StringStore::print();
	StringAccumulator::print();
}

