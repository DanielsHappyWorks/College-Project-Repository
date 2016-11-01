#pragma once
#include <string>
#include <vector>
class StringAccumulator
{
public:
	StringAccumulator(std::string id);
	~StringAccumulator();
	void reset();
	void print();
	void process(std::string data);
	std::string getLargest() const { return largestString; }
	float getAverage();

	float getMedian();
	float getStandardDeviation();

private:
	std::string id;
	//afghanistan
	std::string largestString;
	std::string::size_type largestLength;
	//unsigned int largestLength;
	std::vector<int> lengthVector;
};

