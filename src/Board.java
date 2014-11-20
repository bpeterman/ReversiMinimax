
public class Board {
	static int board[][] = new int[8][8];
	public Board(){
		
	}
	public void init(){
		board[3][4]=1;
		board[4][3]=1;
		board[3][3]=2;
		board[4][4]=2;
	}
	public static void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[j][i] + "|");
			} // j for end
			System.out.println();
		} // i for end
	}
}
