#include "StringStoreAccumulator.h"
using namespace std;

StringStoreAccumulator::StringStoreAccumulator(string id) : id(id)
{
	acc = StringAccumulator(id);
	store = StringStore(id);
}


StringStoreAccumulator::~StringStoreAccumulator()
{
}

void StringStoreAccumulator::add(string s) {
	store.add(s);
	acc.process(s);
}

void StringStoreAccumulator::print() {
	store.print();
	acc.print();
}

