package stickman.model;

/**
 * Implements the Entity interface.
 * Creates a cloud in the level.
 * There can be multiple clouds.
 */
public class Cloud implements IEntity {
    private String imagePath;
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;
    private double cloudVelocity;

    /**
     * Creates a new cloud.
     * @param imagePath The image for the cloud.
     * @param xpos The starting X position of the cloud in the Game Window.
     * @param ypos The starting Y position of the cloud in the Game Window.
     * @param height The height of the cloud in pixels.
     * @param width The width of the cloud in pixels.
     * @param cloudVelocity The speed of the cloud.
     */
    public Cloud(String imagePath, double xpos, double ypos, double height, double width, double cloudVelocity){
        this.imagePath = imagePath;
        this.XPos = xpos;
        this.YPos = ypos;
        this.height = height;
        this.width = width;
        this.cloudVelocity = cloudVelocity;
    }

    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public double getXPos() {
        return this.XPos;
    }

    @Override
    public double getYPos() {
        return this.YPos;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    /**
     * Gets the clouds speed in the level.
     * @return The clouds speed.
     */
    public double getCloudVelocity(){
        return this.cloudVelocity;
    }

    /**
     * Changes the X position of the cloud. This changes
     * when the cloud moves across the screen.
     * @param xpos The current X position of the cloud.
     */
    public void setXPos(double xpos){
        this.XPos = xpos;
    }

    /**
     * Changes the clouds speed.
     * @param cloudVelocity The new speed the cloud should move.
     */
    public void setCloudVelocity(double cloudVelocity){
        this.cloudVelocity = cloudVelocity;
    }

    //added
    @Override
    public void update(){
        setXPos(getXPos() - (getCloudVelocity()/60));
    }

    @Override
    public void handleCollision(IEntity entity){

    }

    @Override
    public void dies(){

    }
}
