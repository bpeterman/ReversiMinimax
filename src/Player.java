public class Player {
	int token;

	public Player(int token) {
		this.token = token;
	}

	public Player getOpposite() {
		if (token == 1) {
			Player player = new Player(2);
			return player;
		}
		Player player = new Player(1);
		return player;
	}

	public int getToken() {
		return token;
	}
}
