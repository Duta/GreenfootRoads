import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
class Point {
	private int x, y;
	private List<Point> joinedPoints = new ArrayList<Point>();

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addJoinedPoint(Point point) {
	    joinedPoints.add(point);
	}
	
	public Point getRandomJoinedPoint() {
	    return joinedPoints.isEmpty()
	         ? null
	         : joinedPoints.get(Greenfoot.getRandomNumber(joinedPoints.size()));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}