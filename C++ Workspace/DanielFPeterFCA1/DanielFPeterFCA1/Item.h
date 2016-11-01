#include <string>
class Item {
public:
	Item();
	Item(std::string name, std::string description);
	~Item();
	void Print(); //prints name and description
		
private:
	std::string name, description;

};