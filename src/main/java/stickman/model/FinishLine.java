package stickman.model;

public class FinishLine implements Entity {
    private String imagePath = "chest.png";
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;

    public FinishLine(){
        //this.XPos = xpos;
        //this.YPos = ypos;
        //this.height = height;
        //this.width = width;
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

    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setXPos(double xpos){
        this.XPos = xpos;
    }
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleCollision(Entity entity) {

    }

    @Override
    public String toString(){
        return "finish";
    }
}
