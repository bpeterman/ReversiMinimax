
public class Main {
	static Board board = new Board();

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		GamePlay game = new GamePlay(board);
	}

}