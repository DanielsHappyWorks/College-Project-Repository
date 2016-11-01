#include <string>

class DayType {
public:
	DayType(int value);
	~DayType();
	void print();
	int next();
	int previous();
	int add(int add);
	int get() const { return value; }

private:
	//std::string[] days = { "Monday","Tuseday","Wednsday","Thursday","Friday","Saturday","Sunday" };
	int value;
	string valueAsString[];

};
