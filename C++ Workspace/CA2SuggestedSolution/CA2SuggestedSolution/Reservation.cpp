#include "Reservation.h"
#include <iostream>

using namespace std;

int Reservation::count = 0; //initialising a static var!!!

Reservation::Reservation()
{
	count++;
}
Reservation::Reservation(unsigned int id, string name,
	unsigned int date, unsigned int month, unsigned int year, unsigned int duration)
{
	count++;
	setID(id);
	setName(name);
	setDate(date);
	setMonth(month);
	setYear(year);
	setDuration(duration);
}

Reservation::~Reservation()
{
	count--;
}

void Reservation::setID(unsigned int id) // > 0
{
	Reservation::id = (id > 0) ? id : 1;
}

void Reservation::setName(string name) // > 0
{
	Reservation::name = (name.length() > 8) ? name : "default name";
}

void Reservation::setDate(unsigned int date) // > 0
{
	Reservation::date = ((date > 0) && (date < 32)) ? date : 1;
}

void Reservation::setMonth(unsigned int month) // > 0
{
	Reservation::month = ((month > 0) && (month < 13)) ? month : 1;
}

void Reservation::setYear(unsigned int year) // > 0
{
	Reservation::year = (year >= 2016) ? year : 2016;
}

void Reservation::setDuration(unsigned int duration) // > 0
{
	Reservation::duration = (duration > 0) ? duration : 1;
}


void Reservation::print() const
{
	cout << "Reservation: " << id << ", " << name << ", " << duration << endl;
}