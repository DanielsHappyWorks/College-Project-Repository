#pragma once
class Room
{
public:
	Room();
	Room(int id, int maxOccupancy,float costPerDay);
	~Room();

	int getId() const { return id; };
	int getMaxOccupancy() const { return maxOccupancy; };
	float getCostPerDay() const { return costPerDay; };

	void setId(int id);
	void setMaxOccupancy(int maxOccupancy);
	void setCostPerDay(float costPerDay);

	void print();

private:
	int id, maxOccupancy;
	float costPerDay;
};

