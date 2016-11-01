#pragma once
#include "StringStore.h"
#include "StringAccumulator.h"

class StringStoreAccumulator
{
public:
	StringStoreAccumulator(std::string id);
	~StringStoreAccumulator();
	void add(std::string s);
	void print();
	StringStore getStore() { return store; }
	StringAccumulator getAcc() { return acc; }
	
private:
	std::string id;
	StringStore store;
	StringAccumulator acc;
};

