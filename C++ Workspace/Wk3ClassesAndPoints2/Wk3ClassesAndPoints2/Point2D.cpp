#include <iostream>
#include <string>
#include "Point2D.h"
using namespace std;

Point2D::Point2D() : x(0), y(0)
{
}
Point2D::Point2D(float x, float y): x(x), y(y)
{
}
Point2D::~Point2D()
{
	cout << "Point2D destructor called:[" << getX() << "," << getY() << "]" << endl;
}

void Point2D::print() const
{
	cout << "[" << getX() << "," 
				<< getY() << "]" << endl;
}


Point2D Point2D::operator+(const Point2D& other)
{
	Point2D pOut;
	pOut.setX(x + other.getX());
	pOut.setY(y + other.getY());
	return pOut;
}

Point2D Point2D::operator*(const Point2D& other)
{
	Point2D pOut;
	pOut.setX(x * other.getX());
	pOut.setY(y * other.getY());
	return pOut;
}

bool Point2D::operator==(const Point2D& other)
{
	return (x == other.getX() && y == other.getY());
}
bool Point2D::operator!=(const Point2D& other)
{
	return !(x == other.getX() && y == other.getY());
}