package stickman.model;

public class Tree implements IEntity{
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;

    public Tree(){
//        this.xpos = xpos;
//        this.ypos = ypos;
//        this.height = height;
//        this.width = width;
    }

    @Override
    public String getImagePath() {
        return "tree2.png";
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

    public void setXPos(double xpos){
        this.XPos = xpos;
    }
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleCollision(IEntity entity) {

    }

    @Override
    public String toString(){
        return "tree";
    }
}
