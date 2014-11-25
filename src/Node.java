import java.util.List;

public class Node {

	public int height;
	public int value;
	public Board board;
	public Board secBoard;
	public List<Node> children;
	public double alpha;
	public double beta;
	public Position move;
	public Player player;
	public boolean isMax;

	public Node(Position move){
		this.move=move;
	}
	
	public Node(Node otherNode){
		
	}

	public boolean isMax() {
		return isMax;
	}

	public void setMax(boolean isMax) {
		this.isMax = isMax;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public Position getMove() {
		return move;
	}

	public void setMove(Position move) {
		this.move = move;
	}

}
