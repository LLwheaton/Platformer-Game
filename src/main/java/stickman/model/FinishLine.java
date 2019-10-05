package stickman.model;

public class FinishLine implements IEntity {
    private String imagePath = "chest.png";
    private double xpos;
    private double ypos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;

    public FinishLine(double xpos, double ypos, double height, double width){
        this.xpos = xpos;
        this.ypos = ypos;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public double getXPos() {
        return this.xpos;
    }

    @Override
    public double getYPos() {
        return this.ypos;
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

    @Override
    public void update() {

    }

    @Override
    public void handleCollision(IEntity entity) {

    }
}
