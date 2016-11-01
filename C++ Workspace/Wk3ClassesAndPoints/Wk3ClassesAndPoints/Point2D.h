class Point2D {//class declatartion
public:
	Point2D();
	Point2D(float x, float y);
	~Point2D();
	float getX() const { return x; }
	float getY() const { return y; }
	void setX(float xValue) { x = xValue; }
	void setY(float yValue) { y = yValue; }
	void print() const;

	//overloading operators
	Point2D operator+(const Point2D& other);
	Point2D operator-(const Point2D& other);
	Point2D operator*(const Point2D& other);
	Point2D operator/(const Point2D& other);
	bool operator==(const Point2D& other);
	bool operator!=(const Point2D& other);

private:
	float x, y;
};