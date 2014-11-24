public class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (((Position) o).getX() == x && ((Position) o).getY() == y)
			return true;
		return false;
	}

	public boolean isValid() {
		if (x >= 8 || x < 0)
			return false;
		if (y >= 8 || y < 0)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
