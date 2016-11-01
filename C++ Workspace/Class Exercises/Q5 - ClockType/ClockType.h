//#pragma once
class ClockType
{
	/*
	The access modifier public or private does not apply
	to a friend function since any function marked as friend
	can access the public and private member variables of the class
	it is a friend of i.e. ClockType. See the method definition in ClockType.cpp to see this in action.

	Overloading this method allows us to write code like the following:
	cout << ClockType(9, 30, 0) << endl;

	or

	ClockType c1;
	cout << c1;

	*/
	friend std::ostream& operator<<(std::ostream& outStream,
				ClockType& clockType);

public:
	ClockType();
	ClockType(int hours, int mins, int seconds);
	~ClockType();
	void print(const char* format);
	int getHours() const { return hours; }
	int getMins() const { return mins; }
	int getSeconds() const { return seconds; }
	void setHours(int hours) { ClockType::hours = hours; }
	void setMins(int hours) { ClockType::mins = hours; }
	void setSeconds(int hours) { ClockType::seconds = hours; }

	/*
	Overloading this method allows us to write code like the following:
	string s = ClockType(9, 30, 0);
	*/
	operator std::string() const;
	
private:
	int hours, mins, seconds;
};