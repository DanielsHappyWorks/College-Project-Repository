#include "TicTacToeBoard.h"

using namespace std;


TicTacToeBoard::TicTacToeBoard() {

}
TicTacToeBoard::~TicTacToeBoard() {

}
void TicTacToeBoard::print() {
	for (int i = 0 ; i < 3; i++) {
		for (int j = 0; j < 3; j++)
		{
			cout << TicTacToeBoard::ticTacToe[i][j] << "	";
		}
		cout << endl;
	}
}
bool TicTacToeBoard::checkIfValid(int row, int column) {
	row -= 1;
	column -= 1;
	if (TicTacToeBoard::getValue(row,column) == 0) {
		return true;
	}
	else
	{
		return false;
	}
}
void TicTacToeBoard::updateBoard(int row, int column, int value) {
	row -= 1;
	column -= 1;
	TicTacToeBoard::ticTacToe[row][column] = value;
}
bool TicTacToeBoard::checkIfWon() {
	//
}
void TicTacToeBoard::restartBoard() {

}