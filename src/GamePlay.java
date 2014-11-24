import java.util.List;
import java.util.Scanner;

public class GamePlay {

	Board board;

	public GamePlay(Board board) {
		this.board = board;
		board.init();
		startGame();
	}

	public void startGame() {
		Player player = new Player(2);
		Scanner in = new Scanner(System.in);
		while (true) {
			board.printBoard();
			List<Position> moves = board.getPossibleMoves(player);
			if (moves.size() > 0) {
				System.out.println("It is player " + player.getToken()
						+ "'s move.");
				System.out.println("Where would you like to move?:");
				System.out.println("X: ");
				int x = in.nextInt();
				System.out.println("Y: ");
				int y = in.nextInt();
				Position myMove = new Position(x, y);
				if (myMove.isValid()) {
					if (moves.contains(myMove)) {
						System.out.println("Good Move");
						board.doMove(myMove, player);
						player = player.getOpposite();
					} else {
						System.out.println("Move Invalid");
					}
				} else {
					System.out.println("Move Invalid");
				}
			} else {
				System.out.println("You have no where to go.");
				player = player.getOpposite();
			}
			if (board.getPossibleMoves(player).size() == 0
					&& board.getPossibleMoves(player.getOpposite()).size() == 0)
				break;
		}
		System.out.println("No more moves available.  Game Over");
		int[] results = board.getBoardScore();
		System.out.println("Player 1 had: " + results[1]
				+ " points and Player 2 had: " + results[2]);
	}

}
