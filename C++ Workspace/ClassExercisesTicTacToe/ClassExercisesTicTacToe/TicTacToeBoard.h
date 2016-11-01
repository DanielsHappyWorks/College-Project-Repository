#include <iostream>
class TicTacToeBoard{
public:
	TicTacToeBoard();
	~TicTacToeBoard();
	void print();
	bool checkIfValid(int row, int column);
	void updateBoard(int row, int column, int value);
	bool checkIfWon();
	void restartBoard();
	int getValue(int row, int column) { return ticTacToe[row][column]; }
	
private:
	int ticTacToe[3][3] = { { 0,0,0 },{ 0,0,0 },{ 0,0,0 } };
};