#include <iostream>
#include <string>
#include <vector>
std::vector<std::string> split(std::string data, std::string delimiter);

int main() {
	std::string data = "a,b,c,d,e";

	std::size_t pos = data.find('l', 0);

	if (pos != std::string::npos)
		std::cout << pos << std::endl;
	else
		std::cout << "Not there" << std::endl;

	std::vector<std::string> myVec = split(data, ",");

	for (std::string s : myVec) {
		std::cout << s << std::endl;
	}

	system("pause");
	return 0;
}

//html like text file?
std::vector<std::string> split(std::string data, std::string delimiter) {
	std::vector<std::string> vec;
	std::string strElement;
	std::size_t pos = data.find(delimiter, 0);
	std::size_t oldPos = 0;

	while (pos != std::string::npos) {
		strElement = data.substr(oldPos, pos-oldPos);
		vec.push_back(strElement);
		oldPos = pos;
		std::size_t pos = data.find(delimiter, 0);

	}

	return vec;
}