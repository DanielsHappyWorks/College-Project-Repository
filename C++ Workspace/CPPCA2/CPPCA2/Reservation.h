#include <string>

class Reservation
{
public:
	Reservation();
	Reservation(int id, int duration, std::string clientName, unsigned int startDate, unsigned int startMonth, unsigned int startYear);
	~Reservation();

	static bool sortByIDOfreservation(Reservation r1, Reservation r2);

	int getId() const { return id; };
	int getDuration() const { return duration; };
	std::string getClientName() const { return clientName; };
	unsigned int getDate() const { return startDate; };
	unsigned int getMonth() const { return startMonth; };
	unsigned int getYear() const { return startYear; };

	void setId(int id);
	void setDuration(int duration);
	void setClientName(std::string clientName);
	void setDate(unsigned int startDate);
	void setMonth(unsigned int startMonth);
	void setYear(unsigned int startYear);

	void print();
	static int reservationCount;
private:
	int id,duration;
	std::string clientName;
	unsigned int startDate, startMonth, startYear;
	
};

