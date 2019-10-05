package stickman.model;

public class Coin implements IEntity {
    private String imagePath = "coin.png";
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;

    public Coin(double xpos, double ypos, double height, double width){
        this.XPos = xpos;
        this.YPos = ypos;
        this.height = height;
        this.width = width;
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
    public void handleCollision(IEntity entity) {

    }
    @Override
    public String toString(){
        return "coin";
    }
}
