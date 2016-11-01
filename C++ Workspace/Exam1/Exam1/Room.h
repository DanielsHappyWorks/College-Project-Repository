#pragma once
class Room
{
public:
	Room();
	Room(unsigned int id, float costPerNight, unsigned int maxOccupancy);
	~Room();

	unsigned int getID() const { return id; }
	float getCostPerNight() const { return costPerNight; }
	unsigned int getMaxOccupancy() const { return maxOccupancy; }

	void setID(unsigned int id);
	void setCostPerNight(float costPerNight);
	void setMaxOccupancy(unsigned int maxOccupancy);

	void print() const;

private:
	unsigned int id;
	float costPerNight;
	unsigned int maxOccupancy;
};

