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
	for (Room r : roomVector)
		r.print();
}
void Hotel::printReservations() const
{
	for (Reservation r : reservationVector)
		r.print();
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

	string name;
	cout << "Enter name(zero-based):" << endl;
	cin >> name;

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

	reservationVector.push_back(Reservation(id, name, date, month, year, duration));
}


