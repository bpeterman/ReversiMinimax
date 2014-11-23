import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Board {
	
	static int board[][] = new int[8][8];
	
	public Board(){
		  
	}
	
	//initializes the beginning of the game board.
	public void init(){
		board[3][4]=1;
		board[4][3]=1;
		board[3][3]=2;
		board[4][4]=2;
	}
	
	//Returns the piece at the location
	public Player getPlayerAtPos(Position pos){
		return new Player(board[pos.getX()][pos.getY()]);
	}
	
	//Player 1's score is index 1.  Player 2 is 2.  0 is empty.
	public int[] getBoardScore(){
		int[] out = new int[3];
		for (int i=0; i<8; ++i){
			for(int j=0; j<8; ++j){
				out[board[j][i]]++;
			}
		}
		return out;
	}
	
	public List<Position> getPossibleMoves(Player player){
		List<Position> locations = getAvailLocations(player.getOpposite());
		System.out.println(player.getToken());
		locations = searchFlips(locations, player);
		
		return locations;
	}
	
	public List<Position> searchFlips(List<Position> pos, Player player){
		List<Position> results = new ArrayList<Position>();
		List<Position> directions = new ArrayList<Position>();
		directions.add(new Position(0,1));
		directions.add(new Position(1,1));
		directions.add(new Position(1,0));
		directions.add(new Position(1,-1));
		directions.add(new Position(0,-1));
		directions.add(new Position(-1,-1));
		directions.add(new Position(-1,0));
		directions.add(new Position(-1,1));
		
		for(int i =0; i<pos.size(); ++i){
			for(int j=0; j<directions.size(); ++j){
				if(isDirValid(pos.get(i), directions.get(j), player))
					results.add(pos.get(i));
			}
		}
		
		return results;
	}
	
	public boolean isDirValid(Position curPos, Position pos, Player player){
		int x = curPos.getX();
		int y = curPos.getY();
		boolean stillValid = true;
		while(stillValid){
			x+=pos.getX();
			y+=pos.getY();
			Position newPos = new Position(x, y);
			if(!newPos.isValid())
				return false;
			if(board[x][y]==0)
				return false;
			if(board[x][y]==player.getToken())
				return false;
			if(board[x][y]==player.getOpposite().getToken()){
				while(stillValid){
					x+=pos.getX();
					y+=pos.getY();
					newPos = new Position(x, y);
					if(!newPos.isValid())
						return false;
					if(board[x][y]==0)
						return false;
					if(board[x][y]==player.getToken())
						return true;
				}
			}
		}
		return true;
		
	}
	
	
	
	public List<Position> getAvailLocations(Player player){
		List<Position> locations = new ArrayList<Position>();
		for (int i=0; i<8; ++i){
			for(int j=0; j<8; ++j){
				if(board[j][i]==0){
					Position pos = new Position(i, j);
					locations.add(pos);
				}
			}
		}
		return locations;
	}
	
	
	
	//Prints the board
	public void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[j][i] + "|");
			} // j for end
			System.out.println();
		} // i for end
	}
	
}
