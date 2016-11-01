#include "Hotel.h"
#include <algorithm>
#include <iostream>

using namespace std;

Hotel::Hotel(std::string name)
{
	setName(name); 
}


Hotel::~Hotel()
{
}

void Hotel::setName(string name) // > 0
{
	Hotel::name = (name.length() > 8) ? name : "default name";
}

void Hotel::printRooms() const
{
	printRooms(Hotel::roomVector); //calls the static version
}

void Hotel::printReservations() const
{
	printReservations(Hotel::reservationVector); //calls the static version
}

void Hotel::printRooms(vector<Room> v)
{
	int index = 0;
	for (Room r : v)
	{
		cout << index << ") ";
		index++;
		r.print();
	}
}

void Hotel::printReservations(vector<Reservation> v)
{
	int index = 0;
	for (Reservation r : v)
	{
		cout << index << ") ";
		index++;
		r.print();
	}
}

vector<Reservation> Hotel::findReservationsByDuration(unsigned int lo, unsigned int hi)
{
	vector<Reservation> outVector;
	unsigned int duration;
	for (Reservation r : reservationVector)
	{
		duration = r.getDuration();
		if ((duration >= lo) && (duration <= hi))
			outVector.push_back(r);
	}
	return outVector;
}


bool compareByID(Reservation r1, Reservation r2)
{
	if (r1.getID() <= r2.getID())
		return true;
	else
		return false;
}


void Hotel::sortByID()
{
	//copy
	vector<Reservation> outVector;
	for (Reservation r : reservationVector)
	{
			outVector.push_back(r);
	}
	
	sort(begin(outVector), end(outVector), compareByID);

	for (Reservation r : outVector)
		r.print();
}

void Hotel::sortByID(vector<Reservation> vIn)
{
	//copy
	vector<Reservation> outVector;
	for (Reservation r : vIn)
	{
		outVector.push_back(r);
	}

	sort(begin(outVector), end(outVector), compareByID);

	for (Reservation r : outVector)
		r.print();
}

void Hotel::makeReservation()
{
	printRooms();

	unsigned int index;
	cout << "Enter ID(zero-based):" << endl;
	cin >> index;

	int id = roomVector[index].getID();

	unsigned int date;
	cout << "Enter date:" << endl;
	cin >> date;

	unsigned int month;
	cout << "Enter month:" << endl;
	cin >> month;

	unsigned int year;
	cout << "Enter year:" << endl;
	cin >> year;

	unsigned int duration;
	cout << "Enter duration:" << endl;
	cin >> duration;

	/*
	Did you have trouble when string was read before the ints?
	This may be because of spaces in your string. In this case
	we can either move the string to the end of the input (not a very robust solution)
	or we can use the code below instead:

	string name;
	cout << "Enter name(zero-based):" << endl;
	getline(cin, name); //stores input in name variable
	cout << "Your name is " << name << endl; //check spaces are supported
	*/
	string name;
	cout << "Enter name:" << endl;
	cin >> name;

	reservationVector.push_back(Reservation(id, name, date, month, year, duration));
}

//useful to add Rooms to the Hotel
void Hotel::addRoom(const Room & r)
{
	roomVector.push_back(r);
}


