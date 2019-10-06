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
//
//    /**
//     * Creates a new cloud.
//     * @param xpos The starting X position of the cloud in the Game Window.
//     * @param ypos The starting Y position of the cloud in the Game Window.
//     */
    public Cloud(){
        //this.imagePath = imagePath;
        //this.XPos = xpos;
        //this.YPos = ypos;
        //this.height = height;
        //this.width = width;
        //this.cloudVelocity = cloudVelocity;
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

    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    /**
     * Changes the clouds speed.
     * @param cloudVelocity The new speed the cloud should move.
     */
    public void setCloudVelocity(double cloudVelocity){
        this.cloudVelocity = cloudVelocity;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    //added
    @Override
    public void update(){
        setXPos(getXPos() - (getCloudVelocity()/60));
    }

    @Override
    public void handleCollision(Entity entity){

    }

    @Override
    public String toString(){
        return "cloud";
    }

}
