#include "Item.h"

class LitItem : Item{
public:
	LitItem();
	LitItem(std::string name, std::string description);
	~LitItem();
	bool isLitItem();
	void setIsLit(bool lit) { isLit = lit; };

private:
	bool isLit;

};
