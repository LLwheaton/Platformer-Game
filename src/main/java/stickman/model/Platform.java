package stickman.model;

public class Platform implements Entity {
    private String imagePath = "platform.png";
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;

    public Platform(){

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
    public void setXPos(double xpos){
        this.XPos = xpos;
    }

    @Override
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    @Override
    public void setHeight(double height){
        this.height = height;
    }

    @Override
    public void setWidth(double width){
        this.width = width;
    }

    @Override
    public void update(){

    }
    @Override
    public void handleCollision(Entity entity){

    }

    @Override
    public String toString(){
        return "platform";
    }
}
