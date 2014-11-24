import java.util.List;

public class Minimax {

	Player player;
	Node minimaxTree;
	Board board;

	public Minimax(Player player, Board board) {
		this.player = player;
		this.board = board;
	}

	// this method will start the minimax search.
	public Position doMiniMax() {
		generateTree(player, board);
		return evaluateTreeWrapper(minimaxTree);
	}

	public void generateTree(Player player, Board board) {
		minimaxTree.height=0;
		minimaxTree.board = board;
		minimaxTree.player = player;
		minimaxTree.isMax = true;
		
	}
	
	public List<Node> genChildren(Node node){
		//be sure to increment the children's height 1 from the passed node.
		
		return null;
	}

	public Position evaluateTreeWrapper(Node node){
		return null;
	}
	
	public Node evaluate(Node node){
		return null;
	}
	
}
