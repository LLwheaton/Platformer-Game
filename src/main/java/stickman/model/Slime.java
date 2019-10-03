package stickman.model;

public class Slime implements IEntity{
    private String[] imagePath = {"slimeBa.png", "slimeBb.png"};
    private int index = 0;
    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;
    private boolean isDead = false;

    private int range = 30;

    public Slime(double xpos, double ypos, double height, double width){
        //this.imagePath = imagePath;
        this.XPos = xpos;
        this.YPos = ypos - height*.3;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getImagePath() {
        if(index == 14){
            index = 0;
        }
        int n = index / 7;
        index++;
        return imagePath[n++];
//        if(index == 0){
//            index = 1;
//            return imagePath[0];
//        } else {
//            index = 0;
//            return imagePath[1];
//        }
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
    public void update(){
        //System.out.println("slime xpos: " + this.XPos);
//        if(this.XPos < 0){
//            this.XPos = 680;
//        }
        this.XPos -= 1;



    }
    public void dies(){
        isDead = true;
    }

    @Override
    public void handleCollision(IEntity entity){

    }

    @Override
    public String toString(){
        return "slime";
    }
}
