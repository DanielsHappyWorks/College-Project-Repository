#include "Reservation.h"
#include <iostream>

using namespace std;

int Reservation::reservationCount = 0;

Reservation::Reservation() : id(1), duration(1), clientName("default"), startDate(1), startMonth(1), startYear(1)
{
}

Reservation::Reservation(int id, int duration, std::string clientName, unsigned int startDate, unsigned int startMonth, unsigned int startYear){
	setId(id);
	setDuration(duration);
	setClientName(clientName);
	setDate(startDate);
	setMonth(startMonth);
	setYear(startYear);

		reservationCount++;
}

Reservation::~Reservation()
{
	reservationCount--;
}

void Reservation::setId(int id){
	if (id>0){
		Reservation::id = id;
	}
}
void Reservation::setDuration(int duration){
	if (duration>0){
		Reservation::duration = duration;
	}
}
void Reservation::setClientName(std::string clientName){
	if (clientName.size() > 8){
		Reservation::clientName = clientName;
	}
}
void Reservation::setDate(unsigned int startDate){
	if (startDate >= 1 && startDate <= 31){
		Reservation::startDate = startDate;
	}
}
void Reservation::setMonth(unsigned int startMonth){
	if (startMonth >= 1 && startMonth <= 12){
		Reservation::startMonth = startMonth;
	}
}
void Reservation::setYear(unsigned int startYear){
	if (startYear >= 2016){
		Reservation::startYear = startYear;
	}
}

void Reservation::print(){
	cout << "ID: " << id << ", Name: " << clientName << ", Date: " << startDate << "/" << startMonth << "/" << startYear << ", Duration: " << duration << endl;
}

bool Reservation::sortByIDOfreservation(Reservation r1, Reservation r2){
	//take both vectors 
	//compare id using if
	// return true if bigger and false if smaller
	if (r1.getId() >= r2.getId()){
		return true;
	}
	else{
		return false;
	}
}