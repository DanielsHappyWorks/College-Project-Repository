#pragma once
#include <string>
#include <vector>
class StringStore
{
public:
	StringStore();
	StringStore(std::string id);
	~StringStore();
	void add(std::string data);
	bool remove(std::string data);
	void print() const;
	int size() const;
	void clear();
private:
	std::string id;
	std::vector<std::string> store;
};

