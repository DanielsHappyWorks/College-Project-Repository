#include <iostream>
#include <vector>
#include <fstream>
#include "Hotel.h"
//#include "Room.h" //don't need since Hotel.h has includes for these two header files
//#include "Reservation.h"
using namespace std;

void writeReservationsToFile(string name, string path, vector<Reservation> v);
vector<Room> loadRoomsFromFile(string name, string path);

int main()
{
	

	//test count
	Reservation r1(101, "john smith", 26, 10, 2016, 1);
	Reservation r2(104, "jane smith", 25, 12, 2016, 7);
	cout << "Reservation Count: " << Reservation::getCount() << endl;

	//add rooms to support calling makeReservation
	Hotel h1("London Hilton");
	h1.addRoom(Room(101, 64.50, 1));
	h1.addRoom(Room(102, 95, 2));
	h1.addRoom(Room(103, 75.50, 1));
	h1.addRoom(Room(104, 125.50, 4));

	//test make reservations
	cout << "Make reservations..." << endl;
	for (int i = 0; i < 2; i++)
		h1.makeReservation();

	//test sort
	h1.sortByID();
	cout << "Print sorted reservations..." << endl;
	h1.printReservations();

	//test find by duration
	cout << "Print reservations by duration..." << endl;
	vector<Reservation> reserveVector = h1.findReservationsByDuration(1, 10);
	Hotel::printReservations(reserveVector); //uses static print in Hotel

	//test save
	vector<Reservation> v;
	v.push_back(r1);
	v.push_back(r2);
	writeReservationsToFile("c:/temp/", "reser.txt", v);

	//test load
	cout << "Print rooms loaded from file..." << endl;
	vector<Room> vRoom = loadRoomsFromFile("c:/temp/", "room.txt");
	for (Room r : vRoom)
		r.print();

	system("pause");
	return 0;
}

vector<Room> loadRoomsFromFile(string path, string name)
{
	vector<Room> outVector;
	ifstream inFile(path + name);

	int id, occ;
	float cost;
	Room r;
	while (!inFile.eof())
	{
		inFile >> id;
		inFile >> cost;
		inFile >> occ;
		outVector.push_back(Room(id, cost, occ));
	}

	inFile.close(); //don't forget to release the file!
	return outVector;
}


void writeReservationsToFile(string path, string name, vector<Reservation> v)
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
	outFile.flush(); //we can flush to ensure all data is written out - usually close() auto flushes
	outFile.close(); //don't forget to release the file!
}




