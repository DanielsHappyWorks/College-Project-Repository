#include <vector>
#include "Item.h"

class Player {
public:
	Player();
	Player(int roomID);
	~Player();
	void pickUpItem();
	void useItem();
	void examineItem();
	void lookAtPlayerItems();
	void examineRoom();
	void lightItem(); //for lit objects

private:
	int roomID;
	std::vector<Item> inContainer;
};