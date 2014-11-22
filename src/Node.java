import java.util.Vector;


public class Node {

	public int height;
	public double value;
	public Node parent;
	public Vector<Node> children;
	public double alpha;
	public double beta;
	Move move = new Move(-1, -1);
	
	public Node(){
		
	}

}
