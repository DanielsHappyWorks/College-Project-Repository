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

	
	std::vector<Reservation> findReservationsByDuration(unsigned int lo, unsigned int hi);
	void sortByID(std::vector<Reservation> v);
	void sortByID();

	void makeReservation();
	void addRoom(const Room& r);

	void printRooms() const;
	void printReservations() const;

	//useful when we need a print function for vector returned by findByReservationDuration
	static void printReservations(std::vector<Reservation> v);
	static void printRooms(std::vector<Room> v);

private:
	std::string name;
	std::vector<Room> roomVector;
	std::vector<Reservation> reservationVector;

};

