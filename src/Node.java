import java.util.Vector;

public class Node {

	public int height;
	public double value;
	public Board board;
	public Node parent;
	public Vector<Node> children;
	public double alpha;
	public double beta;
	public Position move;

	public Node() {

	}

}
