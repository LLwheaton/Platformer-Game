package stickman.model;

public class Coin implements Entity {
    private String imagePath = "coin.png";
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;

    public Coin(){

    }

    @Override
    public String getImagePath() {
        return imagePath;
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
    public void update() {

    }

    @Override
    public void handleCollision(Entity entity) {

    }

    /**
     * Changes the coins height.
     * @param height The new height in pixels.
     */
    public void setHeight(double height){
        this.height = height;
    }

    /**
     * Changes the coins width.
     * @param width The new height in pixels.
     */
    public void setWidth(double width){
        this.width = width;
    }

    /**
     * Changes the coins X Position.
     * @param xpos The new X Position of the coin.
     */
    public void setXPos(double xpos){
        this.XPos = xpos;
    }

    /**
     * Changes the coins Y Position.
     * @param ypos The new Y Position of the coin.
     */
    public void setYPos(double ypos){
        this.YPos = ypos;
    }


    @Override
    public String toString(){
        return "coin";
    }
}
