#pragma once
#include "Room.h"
#include "Reservation.h"
#include <vector>
class Hotel
{
public:
	Hotel();
	Hotel(std::string name);
	~Hotel();

	std::string getName() const { return name; };
	std::vector<Room> getRooms() const { return roomVector; }
	std::vector<Reservation> getReservations() const { return reservationVector; }

	void setName(std::string name);
	void setRoomVector(std::vector<Room> roomVector);
	void setReservationVector(std::vector<Reservation> reservationVector);

	void printRooms();
	void printReservations();

	void makeReservation();
	bool available(Room r);
	std::vector<Reservation> findReservationsByDuration();
	void sortByID(std::vector<Reservation> vector);
	void storeReservationsToFile();
	void loadReservationsFromFile();


private:
	std::string name;
	std::vector<Room> roomVector;
	std::vector<Reservation> reservationVector;
};

