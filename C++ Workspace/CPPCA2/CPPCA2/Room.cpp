#include "Room.h"
#include <iostream>

using namespace std;
		
Room::Room() : id(1), maxOccupancy(1), costPerDay(1)
{
}

Room::Room(int id, int maxOccupancy, float costPerDay)
{
	setId(id);
	setMaxOccupancy(maxOccupancy);
	setCostPerDay(costPerDay);
}

Room::~Room()
{
}

void Room::setId(int id){
	if (id>0){
		Room::id = id;
	}
}
void Room::setMaxOccupancy(int maxOccupancy){
	if (maxOccupancy>0 && maxOccupancy<5){
		Room::maxOccupancy = maxOccupancy;
	}
}
void Room::setCostPerDay(float costPerDay){
	if (costPerDay>0){
		Room::costPerDay = costPerDay;
	}
}

void Room::print(){
	cout << "ID: " << id << ", Cost Per Day: " << costPerDay << ", Max Occupancy: " << maxOccupancy << endl;
}