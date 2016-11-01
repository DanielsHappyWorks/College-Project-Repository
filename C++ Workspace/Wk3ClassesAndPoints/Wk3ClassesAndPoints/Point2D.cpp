#include <string>
#include <iostream>
#include "Point2D.h"

using namespace std;

Point2D::Point2D() : x(0), y(0)
{
}

Point2D::Point2D(float x, float y) : x(x), y(y)
{
}

Point2D::~Point2D() {
	cout << "Destoyed" << endl;
}

void Point2D::print() const {
	cout << "[" << getX() << "," << getY() << "]" << endl;
}

Point2D Point2D::operator+(const Point2D& other) {
	Point2D out;
	out.setX(getX() + other.getX());
	out.setY(getY() + other.getY());
	return out;
}

Point2D Point2D::operator-(const Point2D& other) {
	Point2D out;
	out.setX(getX() - other.getX());
	out.setY(getY() - other.getY());
	return out;
}

Point2D Point2D::operator*(const Point2D& other) {
	Point2D out;
	out.setX(getX() * other.getX());
	out.setY(getY() * other.getY());
	return out;
}

Point2D Point2D::operator/(const Point2D& other) {
	Point2D out;
	out.setX(getX() / other.getX());
	out.setY(getY() / other.getY());
	return out;
}

bool Point2D::operator==(const Point2D& other) {
	if (getX() == other.getX() && getY() == other.getY()) {
		return true;
	}
	else
	{
		return false;
	}
}

bool Point2D::operator!=(const Point2D& other) {
	if (getX() == other.getX() && getY() == other.getY()) {
		return false;
	}
	else
	{
		return true;
	}
}