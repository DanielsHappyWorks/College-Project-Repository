#include "Room.h"
#include <iostream>
using namespace std;

Room::Room()
{
}

Room::Room(unsigned int id, float costPerNight, unsigned int maxOccupancy)
{
	setID(id);
	setCostPerNight(costPerNight);
	setMaxOccupancy(maxOccupancy);
}

Room::~Room()
{
}

void Room::setID(unsigned int id) // > 0
{
	Room::id = (id > 0) ? id : 1;
}
void Room::setCostPerNight(float costPerNight)
{
	Room::costPerNight = (costPerNight > 0) ? costPerNight : 1;
}
void Room::setMaxOccupancy(unsigned int maxOccupancy)
{
	Room::maxOccupancy = ((maxOccupancy > 0) && (maxOccupancy < 5)) ? maxOccupancy : 1;
}

void Room::print() const
{
	cout << "Room: " << id << ", " << costPerNight << ", " << maxOccupancy << endl; 
}