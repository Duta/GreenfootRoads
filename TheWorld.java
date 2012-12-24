import greenfoot.*;
import java.awt.Color;
public class TheWorld extends World {
    private Point rootPoint;

    public TheWorld() {
        super(600, 400, 1, false);
        getBackground().setColor(Color.decode("#444444"));
        getBackground().fill();
        setUpPoints();
        addObject(new RouteFollower(rootPoint), rootPoint.getX(), rootPoint.getY());
    }
    
    public void act() {
        if(Greenfoot.getRandomNumber(150) == 0 && getObjects(RouteFollower.class).size() < 5) {
            addObject(new RouteFollower(rootPoint), rootPoint.getX(), rootPoint.getY());
        }
    }
    
    private void setUpPoints() {
        rootPoint = new Point(50, 350);
        Point topLeftPoint = new Point(50, 50);
        Point topRightPoint = new Point(550, 50);
        Point bottomRightPoint = new Point(550, 350);
        Point centerPoint = new Point(300, 200);
        Point topCenterPoint = new Point(300, 50);
        Point rightCenterPoint = new Point(550, 200);
        Point bottomCenterPoint = new Point(300, 350);
        
        addEdge(rootPoint, bottomCenterPoint);
        addEdge(rootPoint, topLeftPoint);
        addEdge(bottomCenterPoint, bottomRightPoint);
        addEdge(bottomRightPoint, rightCenterPoint);
        addEdge(rightCenterPoint, centerPoint);
        addEdge(centerPoint, bottomCenterPoint);
        addEdge(centerPoint, topCenterPoint);
        addEdge(topCenterPoint, topRightPoint);
        addEdge(topRightPoint, rightCenterPoint);
        addEdge(topCenterPoint, topLeftPoint);
    }
    
    private void addEdge(Point p1, Point p2) {
        p1.addJoinedPoint(p2);
        p2.addJoinedPoint(p1);
        getBackground().setColor(Color.BLACK);
        getBackground().drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        getBackground().setColor(Color.RED);
        getBackground().fillOval(p1.getX() - 5, p1.getY() - 5, 10, 10);
        getBackground().fillOval(p2.getX() - 5, p2.getY() - 5, 10, 10);
    }
}
