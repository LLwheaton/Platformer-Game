package stickman.model;

public class Slime implements IEntity{
    private String[] imagePath = {"slimeBa.png","slimeBb.png"};
    private int index = 0;
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;

    public Slime(double xpos, double ypos, double height, double width){
        this.XPos = xpos;
        this.YPos = ypos;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getImagePath() {
        if(index == 2){
            index = 0;
        }
        return imagePath[index++];
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
}
