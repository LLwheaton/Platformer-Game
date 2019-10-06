package stickman.model;

public interface Controllable {

    /**
     * Tells the hero to jump.
     * @return True if succeeded, else false.
     */
    boolean jump();

    /**
     * Tells the hero to start moving left.
     * @return True if succeeded, else false
     */
    boolean moveLeft();

    /**
     * Tells the hero to start moving right.
     * @return True if succeeded, else false.
     */
    boolean moveRight();

    /**
     * Tells the hero to stop moving left or right. This can only happen
     * if they are currently moving - mid-jump is ok. This should not
     * effect the jump itself.
     * @return True if succeeded, else false.
     */
    boolean stopMoving();
}
