package stickman.model;

public interface IEntity {

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

    void update();

    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
}
