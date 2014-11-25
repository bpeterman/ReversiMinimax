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
		node = evaluate(node);
		for(int i=0; i<node.children.size(); ++i){
			if(node.children.get(i).value==node.value){
				return node.children.get(i).move;
			}
		}
		return null;
	}
	
	public Node evaluate(Node node){
		if(!node.children.isEmpty()){
			int[] scores = new int[node.children.size()];
			for(int i=0; i<node.children.size(); ++i){
				Node evalNode = evaluate(node.children.get(i));
				scores[i]=evalNode.value;
			}
			if(node.isMax){
				int max = scores[0];
				for ( int j = 1; j < scores.length; ++j) {
				    if ( scores[j] > max) {
				    	max = scores[j];
				    }
				}
				    node.value=max;
				    return node;
			}else if(!node.isMax) {
				int min = scores[0];
				for ( int i = 1; i < scores.length; ++i) {
				    if ( scores[i] < min) {
				    	min = scores[i];
				    }
				}
				node.value=min;
				return node;
			}
		} else {
			node.value = node.board.getBoardScore()[node.player.getToken()];
			return node;
		}

		return null;
	}
	
}
