 package com.mygdx.breakout;

public class CollisionCircle extends Collision2D {
    private int radius;
    public CollisionCircle(int _radius) {
        radius = _radius;
    }
    public int getRadius() {
        return radius;
    }
    public boolean collidesWith(CollisionRect coll) {
        int xDist = Math.abs(coll.getWidth() / 2 + coll.x - x);
        int yDist = Math.abs(coll.getHeight() / 2 + coll.y - y);
        return xDist < radius + coll.getWidth() / 2 && yDist < radius + coll.getHeight() / 2;
    }
    public boolean collidesWith(CollisionCircle coll) {
        // TODO: implement this
        return true;
    }
    // Returns the side the rectangle collider hit
    // 0 is upper side
    // 1 is left side
    // 2 is bottom side
    // 3 is right side
    public void checkCollisionSide(CollisionRect coll) {
        float xDist = x - (coll.x + coll.getWidth() / 2);
        float yDist = y - (coll.y + coll.getHeight() / 2);
        float magnitude = (float)Math.sqrt(Math.pow(Math.abs(xDist), 2) + Math.pow(Math.abs(yDist), 2));
        float angle = 0;
        if (yDist >= 0) {
            angle = (float)(Math.acos(xDist / magnitude));
        } else {
            angle = (float)(2 * Math.PI - Math.acos(xDist / magnitude));
        }
        System.out.println(angle / Math.PI);
         
    }
}
