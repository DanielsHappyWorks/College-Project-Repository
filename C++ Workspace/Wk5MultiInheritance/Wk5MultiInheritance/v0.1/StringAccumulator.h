#pragma once
#include <string>
class StringAccumulator
{
public:
	StringAccumulator(std::string id);
	~StringAccumulator();
	void reset();
	void print();
	void process(std::string data);
	std::string getLargest() const { return largestString; }
	float getAverage() const { 
				return static_cast<float>(sum) / count; }
private:
	std::string id;
	//afghanistan
	std::string largestString;
	std::string::size_type largestLength;
	//unsigned int largestLength;
	unsigned int count; //0 - > 4billion
	unsigned int sum;

};

