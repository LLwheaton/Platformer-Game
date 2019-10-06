package stickman.model;

public class Slime implements Entity {
    private String[] imagePath = {"slimeRa.png", "slimeRb.png"};
    private int index = 0;
    private String type;

    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private double velocity;
    private double startXPos;
    private Layer layer = Layer.FOREGROUND;

    public Slime(){
    }

    /**
     * Loops through image array at a slower rate than tick()
     * @return The current imagePath
     */
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
        this.XPos -= this.velocity;
        if(XPos < 0){
            this.XPos = 3500;
        }
    }

    @Override
    public void handleCollision(Entity entity){
        this.XPos = startXPos;
    }

    /**
     * Changes the velocity of the Slime
     * @param velocity The new velocity of the Slime.
     */
    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    /**
     * Sets the start X postion of the slime.
     * @param startXPos The start X position of the slime.
     */
    public void setStartXPos(double startXPos){
        this.startXPos = startXPos;
    }

    @Override
    public String toString(){
        return "slime";
    }
}
