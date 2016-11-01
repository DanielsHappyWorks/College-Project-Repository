#include <string>
#include <iostream>

class Engine {
public:

	Engine();
	Engine(int cc, float weight, int type);
	~Engine();

	void setCC(int cc) { Engine::cc = cc; }
	void setWeight(int weight) { Engine::weight = weight; }
	void setType(int type) { Engine::type = type; }

	int getCC() const { return cc; }
	float getWeight() const { return weight; }
	int getType() const { return type; }

	void print() const;
	std::string to_string() const;

	bool operator==(const Engine& other);
	operator std::string() const;
	friend std::ostream& operator<<(std::ostream& steam, Engine& engine);
private:
	int cc;
	float weight;
	int type;
protected:
};