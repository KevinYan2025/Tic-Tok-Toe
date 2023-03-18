import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		//create a two dimensional char array to represent our board
		char board[][]= {{' ',' ',' '},
						 {' ',' ',' '},
						 {' ',' ',' '}};
		printBoard(board);
		do {
			playerTurn(board);	
			if(whoIsWinner(board,'X')!='X') {
			computerTurn(board);	
			}
		}
		while(whoIsWinner(board,'O')!='O' && whoIsWinner(board,'X')!='X' &&whoIsWinner(board,' ')==' ');

	}
	private static char whoIsWinner(char board[][],char mark) {
		for(int i=0;i<3;i++) {
			if(board[0][i]==mark && board[1][i]==mark && board[2][i]==mark) {
				return mark;
			}
		}
		for(int i=0;i<3;i++) {
			if(board[i][0]==mark && board[i][1]==mark && board[i][2]==mark) {
				return mark;
			}
		}
		if(board[0][0]==mark && board[1][1]==mark && board[2][2]==mark) {
			return mark;
		}else if(board[0][2]==mark && board[1][1]==mark && board[2][0]==mark) {
			return mark;
		}
		return ' ';
	}
	private static void computerTurn(char[][] board) {
		Random random=new Random();
		int computerMove=random.nextInt(9)+1;
		while(true) {
			computerMove=random.nextInt(9)+1;
			if(isValideMove(board,computerMove)) {
			placeMove(board,computerMove,'O');
			break;
			}
		}
		System.out.println("Computer choose "+computerMove);
		if(whoIsWinner(board,'O')=='O') {
			celebrateWinner('O');
		}else if(board[0][0]!=' ' &&board[0][1]!=' ' &&board[0][2]!=' ' &&board[1][0]!=' ' &&
				board[1][1]!=' ' &&board[1][2]!=' ' &&board[2][0]!=' ' &&
				board[2][1]!=' ' &&board[2][2]!=' '  ) {
			celebrateWinner(' ');
		}
	}
	private static void playerTurn(char[][] board) {
		Scanner scanner=new Scanner(System.in); 
		int playerMove=0;
		while(true) {
			System.out.print("Please choose a step: ");
			playerMove=scanner.nextInt();
			if(isValideMove(board,playerMove)) {
				placeMove(board, playerMove, 'X');
				break;
			}
			System.out.println("Invalide step!");
		}
		System.out.println("player choose "+playerMove);
		if(whoIsWinner(board,'X')=='X') {
			celebrateWinner('X');
			return;
		}else if(board[0][0]!=' ' &&board[0][1]!=' ' &&board[0][2]!=' ' &&board[1][0]!=' ' &&
				board[1][1]!=' ' &&board[1][2]!=' ' &&board[2][0]!=' ' &&
				board[2][1]!=' ' &&board[2][2]!=' '  ) {
			celebrateWinner(' ');
			return;
		}
		
	}
	private static void celebrateWinner(char mark) {
		if(mark=='X') {
			System.out.println("You Won the Game!!");
		}else if(mark=='O'){
			System.out.println("Computer Won the Game!!");
		}else{
			System.out.println("The game was tie!!");
		}
	}
	private static boolean isValideMove(char[][] board,int position) {
		switch (position){
		case 1:
			if(board[0][0]==' ') {
			return true;
			}else {
				return false;
			}
		case 2:
			if(board[0][1]==' ') {
			return true;
			}else {
				return false;
			}
		case 3:
			if(board[0][2]==' ') {
			return true;
			}else {
				return false;
			}
		case 4:
			if(board[1][0]==' ') {
			return true;
			}else {
				return false;
			}
		case 5:
			if(board[1][1]==' ') {
			return true;
			}else {
				return false;
			}
		case 6:
			if(board[1][2]==' ') {
			return true;
			}else {
				return false;
			}
		case 7:
			if(board[2][0]==' ') {
			return true;
			}else {
				return false;
			}
		case 8:
			if(board[2][1]==' ') {
			return true;
			}else {
				return false;
			}
		case 9:
			if(board[2][2]==' ') {
			return true;
			}else {
				return false;
			}
		default: return false;
		}
	}
	private static void placeMove(char[][] board , int step,char mark) {
		while(isValideMove(board,step)) {
		switch (step){
		case 1:
			board[0][0]=mark;
			break;
		case 2:
			board[0][1]=mark;
			break;
		case 3:
			board[0][2]=mark;
			break;
		case 4:
			board[1][0]=mark;
			break;
		case 5:
			board[1][1]=mark;
			break;
		case 6:
			board[1][2]=mark;
			break;
		case 7:
			board[2][0]=mark;
			break;
		case 8:
			board[2][1]=mark;
			break;
		case 9:
			board[2][2]=mark;
			break;
		default: System.out.println("please enter a valie step: ");
		}
		printBoard(board);
		}
	}

	//method that print out board
	static void printBoard(char board[][]) {
	//print out the board element with border
		System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
		System.out.println("--|---|--");
		System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
		System.out.println("--|---|--");
		System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
		System.out.println("");
	}

}
