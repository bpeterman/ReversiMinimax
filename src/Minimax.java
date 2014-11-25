// Blake Peterman
// Artificial Intelligence
// 11-25-14
// Reversi MiniMax


import java.util.ArrayList;
import java.util.List;

public class Minimax {

	Player player;
	Node minimaxTree;

	public Minimax(Player player, Board passedBoard) {
		this.player = player;
		Position position = new Position(0, 0);
		minimaxTree = new Node(position);
		minimaxTree.setBoard(passedBoard);
		}

	// this method will start the minimax search.
	public Position doMiniMax() {
		generateTreeWrap(player);
		return evaluateTreeWrapper(minimaxTree);
	}

	public void generateTreeWrap(Player player) {
		minimaxTree.height=0;
		minimaxTree.player = player;
		minimaxTree.isMax = true;
		minimaxTree.children = new ArrayList<Node>();
		
		Node tree = genTree(minimaxTree);
		minimaxTree = tree;
	}
	
	public Node genTree(Node node){
		if(node.height<=2){
			if(node.height%2==0 && node.height>1){
				node.player=node.player.getOpposite();
			}
			if(node.height%2!=0){
				node.player=node.player.getOpposite();
			}
			List<Position> posMoves = node.getBoard().getPossibleMoves(node.player);
			for(int i=0; i<posMoves.size(); ++i){
				Node nextNode = new Node(posMoves.get(i));
				nextNode.setBoard(node.getBoard());
				nextNode.player = node.player;
				nextNode.height = node.height + 1;
				Board nodeBoard = new Board();
				
				
				nodeBoard = new Board(node.board);
				nodeBoard.doMove(new Position(nextNode.getMove()), new Player(nextNode.getPlayer()));
				nextNode.setBoard(nodeBoard);
				nextNode.children = new ArrayList<Node>();
				Node kidNode = genTree(nextNode);
				node.children.add(kidNode);
			}
			return node;
		}
		
		return node;
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
