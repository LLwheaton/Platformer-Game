package stickman.model;

public class Platform implements IEntity {
    private String imagePath = "platform.png";
    private double xpos;
    private double ypos;
    private double height;
    private double width;
    private Layer layer = Layer.BACKGROUND;

    public Platform(double xpos, double ypos, double height, double width){
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
}
