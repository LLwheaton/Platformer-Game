package stickman.model;

import javafx.scene.text.Text;

/**
 * Implements Entity interface.
 * Represents an Entity in a level.
 * There can only be one player.
 */
public class Player implements IEntity, IControllable {
    private String imagePath = "ch_stand1.png";
    private String[] imageGoingRight = {"ch_walk1.png","ch_walk2.png","ch_walk3.png","ch_walk4.png", "ch_walk3.png","ch_walk2.png"};
    private String[] imageGoingLeft = {"ch_walk5.png","ch_walk6.png","ch_walk7.png","ch_walk8.png","ch_walk7.png"};
    private String[] imageStandFromRight = {"ch_stand1.png","ch_stand2.png","ch_stand3.png"};
    private String[] imageStandFromLeft = {"ch_stand4.png","ch_stand5.png","ch_stand6.png"};
    private int index = 0;
    private int numLives;

    private double startXPos;
    private double XPos;
    private double YPos;
    private double playerHeight;
    private double playerWidth;
    private Layer layer = Layer.FOREGROUND;
    private double velocity;
    private String stickmanSize;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isJumping;
    private boolean isStopped;
    private boolean isFacingRight = true;

    private boolean onGround = true;
    private double floorheight = 350;
    private double jumpStrength = 12;
    private double weight = 0.5;
    private boolean onPlatform = false;
    private boolean onFloor = true;

    //boolean canJump = true;

//    /**
//     * Creates a new player and sets booleans for movement
//     * @param xpos The starting X position of the player in the Game Window.
//     * @param ypos The starting Y position of the player in the Game Window.
//     */
    public Player(){

//        this.startXPos = xpos;
//        this.XPos = xpos;
//        this.YPos = ypos - height*.45;
//        this.playerHeight = height;
//        this.playerWidth = width;
        //this.velocity = 2;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isJumping = false;
        this.isStopped = true;

    }

    @Override
    public String getImagePath() {
        if(index == 16){
            index = 0;
        }
        int n = index / 4;
        if(isJumping && isMovingRight){
            isFacingRight = true;
            return "ch_walk2.png";
        }
        if(isJumping && isMovingLeft){
            isFacingRight = false;
            return "ch_walk6.png";
        }
        if(isMovingRight){
            isFacingRight = true;
            index++;
            return imageGoingRight[n];
        }
        if(isMovingLeft){
            isFacingRight = false;
            index++;
            return imageGoingLeft[n];
        }
        if(isFacingRight){
            return "ch_stand1.png";
        } else {
            return "ch_stand4.png";
        }
    }

    @Override
    public double getXPos() { //Need to get from JSON file
        return this.XPos;
    }

    public double getStartXPos(){return this.startXPos;}

    @Override
    public double getYPos() {
        return this.YPos;
    }

    @Override
    public double getHeight() { //need to get from JSON file
        return this.playerHeight;
    }

    @Override
    public double getWidth() {
        return this.playerWidth;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    /**
     * Gets the speed of the player
     * @return The speed.
     */
    public double getVelocity(){
        return this.velocity;
    }

    public double getJumpStrength(){
        return this.jumpStrength;
    }

    /**
     * Sets new height of player.
     * @param playerHeight The new player height in pixels.
     */
    public void setHeight(double playerHeight){
        this.playerHeight = playerHeight;
    }

    public void setOnPlatform(boolean isOnPlatform){
        this.onPlatform = isOnPlatform;
    }

    public void setJumpStrength(double jumpStrength){
        this.jumpStrength = jumpStrength;
    }
    public void setOnGround(boolean onGround){
        this.onGround = onGround;
    }
    /**
     * Sets new width of player.
     * @param playerWidth The new player width in pixels.
     */
    public void setWidth(double playerWidth){
        this.playerWidth = playerWidth;
    }

    /**
     * Changes the players speed.
     * @param velocity The new speed the player should move.
     */
    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    /**
     * Changes the X position of the player. This changes when
     * the player moves across the screen.
     * @param xpos The current X position of the player.
     */
    public void setXPos(double xpos){
        this.XPos = xpos;
    }

    /**
     * Changes the Y position of the player. This changes when
     * the player is jumping.
     * @param ypos The current Y position of the player.
     */
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    public void setStartXPos(double startXPos){
        this.startXPos = startXPos;
    }
//    public void setStickmanSize(String stickmanSize){
//        determineSize(stickmanSize);
//    }

    public void setNumLives(int numLives){
        this.numLives = numLives;
    }

    public void death(){
        numLives--;
        if(numLives <= 0){
            numLives = 0;
            System.out.println("GAME OVER");
        }
    }

    @Override
    public boolean jump() {

        if(isJumping){
            return false;
        }
        isJumping = true;
        return true;
    }

    @Override
    public boolean moveLeft() {

        if(isMovingLeft){
            return false;
        }
        isMovingRight = false;
        isStopped = false;
        isMovingLeft = true;
        return true;
    }
    /*This can only happen if they are not currently moving right (but mid-jump is ok)*/
    @Override
    public boolean moveRight() {

        if(isMovingRight){
            return false;
        }
        isMovingLeft = false;
        isStopped = false;
        isMovingRight = true;
        return true;
    }
    /* Tells the hero to stop moving left or right.
     * This can only happen if they are currently moving - mid-jump is ok.
     * This should not effect the jump itself.*/
    @Override
    public boolean stopMoving() {
        if(isStopped){
            return false;
        }
        if(!isStopped){
            if(isMovingRight){
                isMovingRight = false;
                isStopped = true;
            } else { //player is moving left
                isMovingLeft = false;
                isStopped = true;
            }
            return true;
        }
        return false;
    }

    @Override //gets called in tick
    public void update(){
        //System.out.println("Updating??");
        double y = this.YPos;
        if(isMovingRight){
            //System.out.println("xpos:" + this.XPos);
            this.XPos += velocity;
        }
        if (isMovingLeft) {
            this.XPos -= velocity;
            if (this.XPos <= 0) { //Handles left border
                Text text = new Text(20,20, "Can't go that way");
                this.XPos = 0;
            }
        }
        if(isJumping){
            onGround = false;
            onFloor = false;
            y -= jumpStrength;
            jumpStrength -= weight;
            setYPos(y);
            if(y > floorheight-playerHeight*.4){ //Land on floor
                y = floorheight-playerHeight*.4;
                setYPos(y);
                isJumping = false;
                jumpStrength = 12;
                onGround = true;
                onFloor = true;            }
        } else { //When walking off platform, fall to floor
            jumpStrength = -8;
            y -= jumpStrength;
            jumpStrength -= weight;
            setYPos(y);
            if(y > floorheight-playerHeight*.4){ //Land on floor
                y = floorheight-playerHeight*.4;
                setYPos(y);
                isJumping = false;
                jumpStrength = 12;
                onGround = true;
                onFloor = true;
            }
        }

    }

    @Override
    public void handleCollision(IEntity entity){
        this.YPos = entity.getYPos() - playerHeight*.4;
        isJumping = false; //only allows jump sound
        onGround = true;
        onFloor = false;
        jumpStrength = 12;
    }

    @Override
    public String toString(){
        return "player";
    }
}
