#include "Hotel.h"
#include <iostream>
#include <algorithm>

using namespace std;

Hotel::Hotel() : name("default")
{
}

Hotel::Hotel(std::string name){
	setName(name);
}

Hotel::~Hotel()
{
}

void Hotel::setName(string name){
	if (name.size() > 8){
		Hotel::name = name;
	}
}

void Hotel::setRoomVector(std::vector<Room> roomVector){
	Hotel::roomVector = roomVector;
}
void Hotel::setReservationVector(std::vector<Reservation> reservationVector){
	Hotel::reservationVector = reservationVector;
}

void Hotel::printRooms(){
	for (Room r : roomVector){
		r.print();
	}
}

void Hotel::printReservations(){
	for (Reservation r : reservationVector){
		r.print();
	}
}

void Hotel::makeReservation(){
	vector<Room> availableRooms;

	for (Room r : roomVector){
		if (available(r)){//if room is available the push it back (check if the room id doesnt match any reservation id)
			availableRooms.push_back(r);
		}
	}
	//print rooms
	for (Room r : availableRooms){
		r.print();
	}
	
	//take user input and make a reservation
	cout << "Enter ID: " << endl;
	int id;
	cin >> id;
	cout << "Enter Duration: " << endl;
	int duration;
	cin >> duration;
	cout << "Enter name: " << endl;
	std::string clientName;
	cin >> clientName;
	cout << "Enter start date: " << endl;
	unsigned int startDate;
	cin >> startDate;
	cout << "Enter start month: " << endl;
	unsigned int startMonth;
	cin >> startMonth;
	cout << "Enter start year: " << endl;
	unsigned int startYear;
	cin >> startYear;
	//do for all imputs and create reservation and add it to the reservation vector
	Reservation newReservation(id, duration, clientName, startDate, startMonth, startYear); //put all input into constructor
	reservationVector.push_back(newReservation); //place in vector
}

bool Hotel::available(Room r){
	for (Reservation res : reservationVector){
		if (r.getId() == res.getId()){
			return false;
		}
	}
	return true;
}

std::vector<Reservation> Hotel::findReservationsByDuration(){
	std::vector<Reservation> outvector;

	int userInputStart;
	int userInputEnd;
	cout << "Enter Start Duration: " << endl;
	cin >> userInputStart;
	cout << "Enter End Duration: " << endl;
	cin >> userInputEnd;

	for (Reservation r : reservationVector){
		if (r.getDuration() > userInputStart && r.getDuration() < userInputEnd){
			outvector.push_back(r);
		}
	}

	return outvector;
}

void Hotel::sortByID(std::vector<Reservation> vector){
	std::vector<Reservation> sortedVector;

	for (Reservation r : vector){
		sortedVector.push_back(r);
	}

	//sort
	sort(begin(sortedVector), end(sortedVector), Reservation::sortByIDOfreservation);


	//prints sorted vector
	for (Reservation r : sortedVector){
		r.print();
	}
}

void Hotel::storeReservationsToFile(){
	//take path and file name
	//create file
	//open file
	//for each vector{
	//toString each reservation
	//push the string into a file
	//}
	//close file

}
void Hotel::loadReservationsFromFile(){

}