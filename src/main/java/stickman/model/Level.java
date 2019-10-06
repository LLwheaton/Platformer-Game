package stickman.model;

import java.util.List;

public interface Level {

    /**
     * Tells the view what entities it should be drawing right now.
     * @return List of current entities for this level.
     */
    List<Entity> getEntities();

    /**
     * The height of the level (not necessarily the height of the view)
     * @return The height (should be in the same format as Entity sizes,
     * so number of pixels)
     */
    double getHeight();

    /**
     * The width of the level (almost definitely not the width of the view)
     * @return The width in pixels.
     */
    double getWidth();

    /**
     * This is the way the view tells the model to update - it is the trigger
     * that is sent to the model each frame. The level should react to this event
     */
    void tick();

    /**
     * Tells the view where the ground stops and the sky starts.
     * @return Floor height in pixels.
     */
    double getFloorHeight();

    /**
     * Tells the view the horizontal position of the hero so the camera can follow.
     * @return Should match the hero's Entity.getXPos()
     */
    double getHeroX();

    /**
     * Direct pass through.
     * @return True if succeeded, else false.
     */
    boolean jump();

    /**
     * Direct pass through.
     * @return True if succeeded, else false
     */
    boolean moveLeft();

    /**
     * Direct pass through.
     * @return True if succeeded, else false.
     */
    boolean moveRight();

    /**
     * Direct pass through.
     * @return True if succeeded, else false.
     */
    boolean stopMoving();
}
