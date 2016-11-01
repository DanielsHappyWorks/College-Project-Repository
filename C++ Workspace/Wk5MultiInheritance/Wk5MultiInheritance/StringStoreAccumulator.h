#pragma once
#include "StringStore.h"
#include "StringAccumulator.h"

class StringStoreAccumulator : public StringStore, public StringAccumulator
{
public:
	StringStoreAccumulator(std::string id);
	~StringStoreAccumulator();
	void add(std::string s);
	void print();
};

