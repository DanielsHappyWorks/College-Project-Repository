#pragma once
#include <string>

class Reservation
{
public:
	Reservation();
	Reservation(unsigned int id, std::string name,
		unsigned int date, unsigned int month, 
		unsigned int year, unsigned int duration);
	~Reservation();

	unsigned int getID() const { return id; }
	std::string getName() const { return name; }
	unsigned int getDate() const { return date; }
	unsigned int getMonth() const { return month; }
	unsigned int getYear() const { return year; }
	unsigned int getDuration() const { return duration; }
	static int getCount() { return count; }


	void setID(unsigned int id);
	void setName(std::string name);
	void setDate(unsigned int date);
	void setMonth(unsigned int month);
	void setYear(unsigned int year);
	void setDuration(unsigned int duration);

	void print() const;

private:
	unsigned int id, date, month, year, duration;
	std::string name;

	static int count;
};

