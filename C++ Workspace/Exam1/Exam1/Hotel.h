#pragma once
#include <string>
#include <vector>
#include "Room.h"
#include "Reservation.h"
class Hotel
{
public:
	Hotel(std::string name);
	~Hotel();

	void setName(std::string name);

	void printRooms() const;
	void printReservations() const;

	std::vector<Reservation> findReservationsByDuration(unsigned int lo, unsigned int hi);
	void sortByID(std::vector<Reservation> v);
	void sortByID();

	void makeReservation();

private:
	std::string name;
	std::vector<Room> roomVector;
	std::vector<Reservation> reservationVector;

};

