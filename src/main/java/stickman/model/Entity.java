package stickman.model;

public interface Entity {

    /**
     * Tells the view the image path for the entity at the current
     * moment in time (this means the image can change, enabling
     * simple gif-like animation)
     * @return The path of the image where resources/ is the relative root ("example.png")
     */
    String getImagePath();

    /**
     * Tells the view what the x position of the entity currently is.
     * @return The x position using the top left hand corner as 0,0 and
     * increasing as the position moves right.
     */
    double getXPos();

    /**
     * Tells the view what the y position of the entity currently is.
     * @return The y position using the top left hand corner as 0,0 and
     * increasing as the position moves DOWN (JavaFX does not use the
     * standard mathematics axes with the origin in the bottom left).
     */
    double getYPos();

    /**
     * Tells the view how tall to draw the given entity (can change over time)
     * @return The height in co-ordinate space (effectively number of pixels).
     */
    double getHeight();

    /**
     * Tells the view how wide to draw the given entity (can change over time)
     * @return The width in co-ordinate space (effectively number of pixels).
     */
    double getWidth();

    /**
     * Tells the view what Z-order to draw the entity on - to the back, or to the front.
     * @return The layer to draw the entity on
     */
    Layer getLayer();

    /**
     * Sets new height of entity.
     * @param height The new entity height in pixels.
     */
    void setHeight(double height);

    /**
     * Sets new width of entity.
     * @param width The new entity width in pixels.
     */
    void setWidth(double width);

    /**
     * Changes the X position of the entity.
     * @param XPos The current X position of the entity.
     */
    void setXPos(double XPos);

    /**
     * Changes the Y position of the entity.
     * @param YPos The current Y position of the entity.
     */
    void setYPos(double YPos);

    /**
     * Called within tick(), handles any entity actions.
     */
    void update();

    /**
     * Handles a collision between the entity and another entity.
     * @param entity The entity this one collided with.
     */
    void handleCollision(Entity entity);

    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
}
