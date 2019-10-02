package stickman.model;

/**
 * Implements Entity interface.
 * Represents an Entity in a level.
 * There can only be one player.
 */
public class Player implements IEntity, IControllable {
    private String imagePath = "ch_stand1.png";
    private String[] imageGoingRight = {"ch_walk1.png","ch_walk2.png","ch_walk3.png","ch_walk4.png"};
    private String[] imageGoingLeft = {"ch_walk5.png","ch_walk6.png","ch_walk7.png","ch_walk8.png"};
    private String[] imageStandFromRight = {"ch_stand1.png","ch_stand2.png","ch_stand3.png"};
    private String[] imageStandFromLeft = {"ch_stand4.png","ch_stand5.png","ch_stand6.png"};
    private int index = 0;
    //boolean flag = true;
    private boolean isFacingRight = true;

    private double XPos;
    private double YPos;
    private double height;
    private double width;
    private Layer layer = Layer.FOREGROUND;
    private double velocity;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isJumping;
    private boolean isStopped;

    /**
     * Creates a new player and sets booleans for movement
     * @param xpos The starting X position of the player in the Game Window.
     * @param ypos The starting Y position of the player in the Game Window.
     * @param height The height of the player in pixels.
     * @param width The width of the player in pixels.
     * @param velocity The speed the player will move.
     */
    public Player(double xpos, double ypos, double height, double width, double velocity){
        this.XPos = xpos;
        this.YPos = ypos;
        this.height = height;
        this.width = width;
        this.velocity = velocity;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isJumping = false;
        this.isStopped = true;
    }

    @Override
    public String getImagePath() { //needs to change based on walking direction
        //return  this.imagePath;
        if(index == 4){
            index = 0;
        }
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
            return imageGoingRight[index++];
        }
        if(isMovingLeft){
            isFacingRight = false;
            return imageGoingLeft[index++];
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

    @Override
    public double getYPos() {
        return this.YPos;
    }

    @Override
    public double getHeight() { //need to get from JSON file
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

    /**
     * Gets the speed of the player
     * @return The speed.
     */
    public double getVelocity(){
        return this.velocity;
    }

    /**
     * Checks if the player is currently moving to the right.
     * @return True if player is moving right, else false.
     */
    public boolean isMovingRight(){
        return this.isMovingRight;
    }

    /**
     * Checks if player is currently moving to the left.
     * @return True if player is moving left, else false.
     */
    public boolean isMovingLeft(){
        return this.isMovingLeft;
    }

    /**
     * Checks if player is currently jumping.
     * @return True if player is jumping, else false.
     */
    public boolean isJumping(){
        return this.isJumping;
    }

    /**
     * Checks if player is not currently moving.
     * @return True if player is not moving, else false.
     */
    public boolean isStopped(){
        return this.isStopped;
    }

    /**
     * Sets new height of player.
     * @param height The new player height in pixels.
     */
    public void setHeight(double height){
        this.height = height;
    }

    /**
     * Sets new width of player.
     * @param width The new player width in pixels.
     */
    public void setWidth(double width){
        this.width = width;
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

    /**
     * Sets to true if player is moving right, false otherwise.
     * @param isMovingRight The boolean determining if the player is moving right.
     */
    public void setIsMovingRight(boolean isMovingRight){
        this.isMovingRight = isMovingRight;
    }

    /**
     * Sets to true if player is moving left, false otherwise.
     * @param isMovingLeft The boolean determining if the player is moving left.
     */
    public void setIsMovingLeft(boolean isMovingLeft){
        this.isMovingLeft = isMovingLeft;
    }

    /**
     * Sets to true if the player is jumping, false otherwise.
     * @param isJumping The boolean determining if the player is jumping.
     */
    public void setIsJumping(boolean isJumping){
        this.isJumping = isJumping;
    }

    /**
     * Sets to true if the player is not moving, false otherwise.
     * @param isStopped The boolean determining if the player is not moving.
     */
    public void setIsStopped(boolean isStopped){
        this.isStopped = isStopped;
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
}
