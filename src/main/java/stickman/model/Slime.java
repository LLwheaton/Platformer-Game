package stickman.model;

public class Slime implements IEntity{
    private String[] imagePath = {"slimeRa.png", "slimeRb.png"};
    private int index = 0;
    private String type;
    private double velocity;
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;

    private int range = 30;

    public Slime(){
        //this.imagePath = determineImages(type);
        //this.type = type;
//        this.XPos = xpos;
//        this.YPos = ypos - height*.3;
//        this.height = height;
//        this.width = width;
    }

    @Override
    public String getImagePath() {
        if(index == 14){
            index = 0;
        }
        int n = index / 7;
        index++;
        return imagePath[n];
    }

//    public String[] determineImages(String type){
//        switch (type) {
//            case "blue": return new String[]{"slimeBa.png", "slimeBb.png"};
//            case "green": return new String[]{"slimeGa.png","slimeGb.png"};
//            case "red": return new String[]{"slimeRa.png", "slimeRb.png"};
//            case "purple": return new String[]{"slimePa.png","slimePb.png"};
//            case "yellow": return new String[]{"slimeYa.png","slimeYb.png"};
//            default: throw new IllegalArgumentException("Valid slime colour not given");
//        }
//    }

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

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public void setXPos(double xpos){
        this.XPos = xpos;
    }
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    @Override
    public void update(){
        this.XPos -= this.velocity;
        if(XPos < 0){
            this.XPos = 3500;
        }
    }

    @Override
    public void handleCollision(IEntity entity){

    }

    @Override
    public String toString(){
        return "slime";
    }
}
