#include <string>
#include <vector>
#include "Item.h"

class Room {
public:
	Room();
	Room(int id, std::string name, std::string description,int connectedTo, std::vector<Item> itemsInRoom);
	~Room();
	int getID();
	void Print(); //name and description
	int RemoveItem();

private:
	int id;
	std::string name,description;
	int connectedTo[4]; //north,south,east,west (if -1 then 0) uses ids
	std::vector<Item> itemsInRoom;
};