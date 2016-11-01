#include <iostream>
#include "StringStore.h"
using namespace std;
StringStore::StringStore()
{
}
StringStore::StringStore(string id) : id(id)
{
}
StringStore::~StringStore()
{
}
int StringStore::size() const
{
	return store.size();
}
void StringStore::clear()
{
	store.clear();
}
void StringStore::add(string data)
{
	store.push_back(data); 	//uniqueness?
} 
bool StringStore::remove(string data)
{
	return false;  //to do...
}
void StringStore::print() const
{
	for (string s : store)
		cout << s << endl;
}