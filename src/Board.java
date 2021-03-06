import java.util.ArrayList;
import java.util.List;

public class Board {

	private int board[][] = new int[8][8];

	public Board() {

	}
	
	public Board(Board anotherBoard) {
		int theArray[][]  = new int[8][8];
		for(int i =0; i<anotherBoard.board.length; ++i){
			for(int j=0; j<anotherBoard.board.length; ++j){
				theArray[i][j]=anotherBoard.board[i][j];
			}
		}
		board=theArray;
	}
	


//	public static int[][] getBoard() {
//		return board;
//	}
//
//	public static void setBoard(int[][] board) {
//		Board.board = board;
//	}

	// initializes the beginning of the game board.
	public void init() {
		board[3][4] = 1;
		board[4][3] = 1;
		board[3][3] = 2;
		board[4][4] = 2;
	}

	public void doMove(Position pos, Player player) {
		List<Position> directions = new ArrayList<Position>();
		directions.add(new Position(0, 1));
		directions.add(new Position(1, 1));
		directions.add(new Position(1, 0));
		directions.add(new Position(1, -1));
		directions.add(new Position(0, -1));
		directions.add(new Position(-1, -1));
		directions.add(new Position(-1, 0));
		directions.add(new Position(-1, 1));

		for (int j = 0; j < directions.size(); ++j) {
			getFlips(pos, directions.get(j), player);
		}
		this.board[pos.getX()][pos.getY()] = player.getToken();
	}

	public void getFlips(Position pos, Position direction, Player player) {
		List<Position> flips = new ArrayList<Position>();
		int x = pos.getX();
		int y = pos.getY();
		boolean stillValid = true;

		x += direction.getX();
		y += direction.getY();
		Position newPos = new Position(x, y);
		if (!newPos.isValid())
			return;
		if (this.board[x][y] == 0)
			return;
		if (this.board[x][y] == player.getToken())
			return;
		if (this.board[x][y] == player.getOpposite().getToken()) {
			flips.add(newPos);
			while (stillValid) {
				x += direction.getX();
				y += direction.getY();
				newPos = new Position(x, y);
				if (!newPos.isValid())
					return;
				if (this.board[x][y] == 0)
					return;
				if (this.board[x][y] == player.getOpposite().getToken())
					flips.add(newPos);
				if (this.board[x][y] == player.getToken())
					break;
			}
		}

		doFlips(flips);
	}

	public void doFlips(List<Position> flips) {
		for (int i = 0; i < flips.size(); ++i) {
			int x = flips.get(i).getX();
			int y = flips.get(i).getY();
			if (this.board[x][y] == 1)
				this.board[x][y] = 2;
			else
				this.board[x][y] = 1;
		}
	}

	// Returns the piece at the location
	public Player getPlayerAtPos(Position pos) {
		return new Player(board[pos.getX()][pos.getY()]);
	}

	// Player 1's score is index 1. Player 2 is 2. 0 is empty.
	public int[] getBoardScore() {
		int[] out = new int[3];
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				out[board[j][i]]++;
			}
		}
		return out;
	}

	public List<Position> getPossibleMoves(Player player) {
		List<Position> locations = getAvailLocations(player.getOpposite());
		locations = searchFlips(locations, player);

		return locations;
	}

	public List<Position> searchFlips(List<Position> pos, Player player) {
		List<Position> results = new ArrayList<Position>();
		List<Position> directions = new ArrayList<Position>();
		directions.add(new Position(0, 1));
		directions.add(new Position(1, 1));
		directions.add(new Position(1, 0));
		directions.add(new Position(1, -1));
		directions.add(new Position(0, -1));
		directions.add(new Position(-1, -1));
		directions.add(new Position(-1, 0));
		directions.add(new Position(-1, 1));

		for (int i = 0; i < pos.size(); ++i) {
			for (int j = 0; j < directions.size(); ++j) {
				if (isDirValid(pos.get(i), directions.get(j), player))
					results.add(pos.get(i));
			}
		}

		return results;
	}

	public boolean isDirValid(Position curPos, Position pos, Player player) {
		int x = curPos.getX();
		int y = curPos.getY();
		boolean stillValid = true;
		while (stillValid) {
			x += pos.getX();
			y += pos.getY();
			Position newPos = new Position(x, y);
			if (!newPos.isValid())
				return false;
			if (board[x][y] == 0)
				return false;
			if (board[x][y] == player.getToken())
				return false;
			if (board[x][y] == player.getOpposite().getToken()) {
				while (stillValid) {
					x += pos.getX();
					y += pos.getY();
					newPos = new Position(x, y);
					if (!newPos.isValid())
						return false;
					if (board[x][y] == 0)
						return false;
					if (board[x][y] == player.getToken())
						return true;
				}
			}
		}
		return true;

	}

	public List<Position> getAvailLocations(Player player) {
		List<Position> locations = new ArrayList<Position>();
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (board[i][j] == 0) {
					Position pos = new Position(i, j);
					locations.add(pos);
				}
			}
		}
		return locations;
	}

	// Prints the board
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[j][i] + "|");
			} // j for end
			System.out.println();
		} // i for end
	}

}
