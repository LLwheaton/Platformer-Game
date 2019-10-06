package stickman.model;

/**
 * Implements the Entity interface.
 * Creates a cloud in the level.
 * There can be multiple clouds.
 */
public class Cloud implements Entity {
    private String imagePath = "cloud_2.png";
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;
    private double cloudVelocity;

    /**
     * Creates a new cloud.
     */
    public Cloud(){

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

    @Override
    public void update(){
        setXPos(getXPos() - (getCloudVelocity()/60));
    }

    @Override
    public void handleCollision(Entity entity){

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
     * Changes the clouds Y position.
     * @param ypos The given Y position of the cloud.
     */
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    /**
     * Changes the clouds height.
     * @param height The new height in pixels.
     */
    public void setHeight(double height){
        this.height = height;
    }

    /**
     * Changes the clouds width.
     * @param width The new height in pixels.
     */
    public void setWidth(double width){
        this.width = width;
    }

    /**
     * Changes the clouds speed.
     * @param cloudVelocity The new speed the cloud should move.
     */
    public void setCloudVelocity(double cloudVelocity){
        this.cloudVelocity = cloudVelocity;
    }

    @Override
    public String toString(){
        return "cloud";
    }
}
