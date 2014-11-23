import java.util.List;
import java.util.Scanner;


public class GamePlay {
	
	Board board;
	
	public GamePlay(Board board){
		this.board = board;
		board.init();
		startGame();
	}
	
	public void startGame(){
		Player player = new Player(2);
		Scanner in = new Scanner(System.in);
		while(true){
			board.printBoard();
			List<Position> moves = board.getPossibleMoves(player);
			if(moves.size()>0){
				System.out.println("Where would you like to move?:");
				System.out.println("X: ");
				int x = in.nextInt();
				System.out.println("Y: ");
				int y = in.nextInt();
				Position myMove = new Position(x, y);
				if(myMove.isValid()){
					if(moves.contains(myMove)){
						System.out.println("Good Move");
					} else {
						System.out.println("Move Invalid");
					}
				} else{
					System.out.println("Move Invalid");
				}
			}
		}
	}
	
}
