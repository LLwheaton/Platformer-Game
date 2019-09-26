package stickman.model;

public interface GameEngine {

    /**
     * Gives the view the level that is currently loaded (for stage 1
     * this will always be the same level.
     * @return The current level.
     */
    Level getCurrentLevel();

    /** Starts the level running */
    void startLevel();

    /**
     * Direct pass through.
     * @return True if the command succeeded, else false.
     */
    boolean jump();

    /**
     * @return True if the command succeeded, else false.
     */
    boolean moveLeft();

    /**
     * @return True if the command succeeded, else false.
     */
    boolean moveRight();

    /**
     * @return True if the command succeeded, else false.
     */
    boolean stopMoving();

    void tick();
}
