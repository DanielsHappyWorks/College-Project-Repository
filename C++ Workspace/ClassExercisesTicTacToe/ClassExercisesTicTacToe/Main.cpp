#include <iostream>
#include "TicTacToeBoard.h"




using namespace std;

struct Player {
		int row;
		int column;
		int character;
	};
void play(Player& play);
void ticTacToe();
TicTacToeBoard b1 = TicTacToeBoard();

int main() {
	ticTacToe();

	system("pause");
	return 0;
}

void ticTacToe() {	
	Player p1,p2;

	p1.character = 1;
	p2.character = -1;

	
	cout << "Welcome to TicTacToe!" << endl;
	b1.print();


	while(!b1.checkIfWon()){
		cout << "Player 1 please enter the row and column for your move:" << endl;
		play(p1);
		b1.print();
		cout << "Player 2 please enter the row and column for your move:" << endl;
		play(p2);
		b1.print();
	}
}

void play(Player& player) {
	cout << "Row: ";
	cin >> player.row;
	cout << "Column: ";
	cin >> player.column;
	if((player.row<3 && player.row>0) && (player.column<3 && player.column>0)){ 
		if (b1.checkIfValid(player.row, player.column)) {
			b1.updateBoard(player.row, player.column, player.character);
		}
		else {
			cout << "Invalid Input" << endl;
			play(player);
		}
	}
	else
	{
		cout << "Invalid Input" << endl;
		play(player);
	}
}
