/*#include <iostream>
int shiftLeft(int value, int shiftBy);
void shiftRight(int& value, int& shiftBy);
bool isBitSet(int& value, int& postition);

//using namespace std;

int main() {
	std::cout << "Starting..." << std::endl;

	for (int i = 0; i<8; i++) {
		std::cout << " Shift 1 left by 10: "<<shiftLeft(1,10) << std::endl;
	}

	std::cout << std::endl;

	int value = 486513165;
	for(int j=0; j<8; j++){
		shiftRight(value, j);
		std::cout << " Shift right by 2: " << value << std::endl;
	}
	int is1 = 7, is2 = 2;
	bool isSet = isBitSet(is1, is2);
	std::cout << " Is the bit set: " << isSet << std::endl;

	system("pause");
	return 0;
}

int shiftLeft(int value, int shiftBy) {
	return value << shiftBy;
}

void shiftRight(int& value, int& shiftBy) {
	value = value >> shiftBy;
}

bool isBitSet(int& value, int& postition) {
	int temp = (1 << postition) & value;
	return  (temp > 0) ? true : false;

	//return  (((1 << postition) & value) > 0) ? true : false;
}*/