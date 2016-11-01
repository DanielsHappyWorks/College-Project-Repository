#include "Item.h"
#include <vector>

class ContainerItem : Item {
public:
	ContainerItem();
	ContainerItem(std::string name, std::string description);
	~ContainerItem();
	void addItem();
	void lookInside();
	bool removeItem();

private:
	std::vector<Item> inContainer;

};