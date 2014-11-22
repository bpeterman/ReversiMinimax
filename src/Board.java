
public class Board {
	static int board[][] = new int[8][8];
	public Board(){
		
	}
	
	//initializes the beginning of the game board.
	public void init(){
		board[3][4]=1;
		board[4][3]=1;
		board[3][3]=2;
		board[4][4]=2;
	}
	
	//Player 1's score is index 1.  Player 2 is 2
	public int[] getBoardScore(){
		int[] out = new int[3];
		
		return out;
	}
	
	//Prints the board
	public static void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[j][i] + "|");
			} // j for end
			System.out.println();
		} // i for end
	}
	
}
