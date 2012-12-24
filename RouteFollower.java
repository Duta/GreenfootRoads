import greenfoot.*;
class RouteFollower extends Actor {
    private Point point;
    private int speed = 3;

    public RouteFollower(Point point) {
        this.point = point;
    }

    public void act() {
        if(point == null) {
            getWorld().removeObject(this);
            return;
        }
        moveTowardsPoint();
        if(isAtPoint()) {
            point = point.getRandomJoinedPoint();
        }
    }

    public void moveTowardsPoint() {
        turnTowards(point.getX(), point.getY());
        move(speed);
    }

    public boolean isAtPoint() {
        int xDiff = Math.abs(point.getX() - getX());
        int yDiff = Math.abs(point.getY() - getY());
        int totalDiff = xDiff + yDiff;
        return totalDiff < speed;
    }
}