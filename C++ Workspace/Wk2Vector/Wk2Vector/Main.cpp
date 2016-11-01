#include <iostream>
#include <vector>
#include <string>
#include <iterator>
#include <algorithm>

void demoSimple();
bool compareStrings(std::string a, std::string b);

int main() {
	demoSimple();
	system("Pause");
	return 0;
}

void demoSimple() {
	std::vector<std::string> nameVector;

	nameVector.push_back("today");
	nameVector.push_back("is");
	nameVector.push_back("friday");

	std::cout << "Size: " << nameVector.size() << std::endl;

	//range for loop
	for (std::string s : nameVector)
		std::cout << s << std::endl;

	int size = nameVector.size();
	int i = 0;
	while (i < size) {
		std::cout << nameVector[i]<< std::endl;
		i++;
	}

	std::vector<std::string>::iterator itBeg = nameVector.begin();
	std::vector<std::string>::iterator itEnd = nameVector.end();

	for (std::vector<std::string>::iterator it = itBeg; it != itEnd; it++) {
		std::cout << *it << std::endl;
	}

	nameVector.erase(end(nameVector)-1);
	nameVector.insert(end(nameVector),"Lol");

	for (std::string s : nameVector)
		std::cout << s << std::endl;

	std::vector<std::string> monthVector;
	monthVector.push_back("Jan");
	monthVector.push_back("Feb");
	monthVector.push_back("Mar");

	nameVector.insert(begin(nameVector), begin(monthVector) + 1, end(monthVector));
	for (std::string s : nameVector)
		std::cout << s << std::endl;

	std::sort(begin(nameVector), end(nameVector), compareStrings);
	for (std::string s : nameVector)
		std::cout << s << std::endl;

	std::random_shuffle(begin(nameVector), end(nameVector));
	for (std::string s : nameVector)
		std::cout << s << std::endl;
}
bool compareStrings(std::string a, std::string b) {
	if (a.length() > b.length()) {
		return true;
	}
	else {
		return false;
	}
}