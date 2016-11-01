#include <iostream>
#include <vector>
#include <fstream>
#include "Room.h"
#include "Reservation.h"
using namespace std;

void writeReservationsToFile(string name, string path,
	vector<Reservation> v);
vector<Room> loadRoomsFromFile(string name, string path);
int main()
{
	Reservation r1(101, "john smith", 26, 10, 2016, 1);
	Reservation r2(104, "jane smith", 25, 12, 2016, 7);
	vector<Reservation> v;
	v.push_back(r1);
	v.push_back(r2);
	writeReservationsToFile("", "reser.txt", v);

	vector<Room> vRoom = loadRoomsFromFile("", "room.txt");
	for (Room r : vRoom)
		r.print();

	system("pause");
	return 0;
}

vector<Room> loadRoomsFromFile(string name, string path)
{
	vector<Room> outVector;

	ifstream inFile(path + name);

	unsigned int id, occ;
	float cost;
	Room r;
	while (!inFile.eof())
	{
		inFile >> id;
		inFile >> cost;
		inFile >> occ;
		
		//Room r(id, cost, occ);
		r.setID(id);
		r.setCostPerNight(cost);
		r.setMaxOccupancy(occ);
		outVector.push_back(r);	
		//outVector.push_back(Room(id, cost, occ));
	}

	inFile.close();
	return outVector;

}


void writeReservationsToFile(string name, string path,
	vector<Reservation> v)
{
	ofstream outFile;
	outFile.open(path + name);

	for (Reservation r : v)
	{
		outFile << r.getID() << endl;
		outFile << r.getName() << endl;
		outFile << r.getDate() << endl;
		outFile << r.getMonth() << endl;
		outFile << r.getYear() << endl;
		outFile << r.getDuration() << endl;
	}

	//outFile.flush();
	outFile.close();
}




