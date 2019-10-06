package stickman.model;

public interface Controllable {
    boolean jump();
    boolean moveLeft();
    boolean moveRight();
    boolean stopMoving();
}
