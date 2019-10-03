package stickman.model;

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

    private double startXPos;
    private double XPos;
    private double YPos;
    private double playerHeight;
    private double playerWidth;
    private Layer layer = Layer.FOREGROUND;
    private double velocity;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isJumping;
    private boolean isStopped;
    private boolean isFacingRight = true;

    private boolean onGround = true;
    private double floorheight = 350;
    private double jumpStrength = 5;
    private double weight = 0.1;
    private boolean onPlatform = false;

    /**
     * Creates a new player and sets booleans for movement
     * @param xpos The starting X position of the player in the Game Window.
     * @param ypos The starting Y position of the player in the Game Window.
     * @param stickmanSize The size of stickman as a string.
     */
    public Player(double xpos, double ypos, String stickmanSize){
        determineSize(stickmanSize);
        this.startXPos = xpos;
        this.XPos = xpos;
        this.YPos = ypos - playerHeight*.45;
        this.velocity = 1;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isJumping = false;
        this.isStopped = true;

    }

    private void determineSize(String size){
            if(size.toLowerCase().equals("tiny")){
                this.playerHeight = 40.0;
                this.playerWidth = 12.0;
            } else if(size.toLowerCase().equals("normal")){
                this.playerHeight = 75.0;
                this.playerWidth = 20.0;
            } else if(size.toLowerCase().equals("large")){
                this.playerHeight = 110.0;
                this.playerWidth =  30.0;
            } else if(size.toLowerCase().equals("giant")){
                this.playerHeight = 160.0;
                this.playerWidth = 42.0;
            } else { //This should never happen if json file is correct
                //Set to normal
                System.out.println("Unable to get proper size. Default: Normal");
                this.playerHeight = 40.0;
                this.playerWidth = 12.0;
            }
    }

    @Override
    public String getImagePath() { //needs to change based on walking direction
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
            return imageGoingRight[n++];
        }
        if(isMovingLeft){
            isFacingRight = false;
            index++;
            return imageGoingLeft[n++];
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

    public void setJumpStrength(double jumpStrength){
        this.jumpStrength = jumpStrength;
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
        //System.out.println("Ypos: " + this.YPos);
        double y = this.YPos;
        //If player moves right, set X position to increment by players velocity
        if(isMovingRight){
            //double x = this.XPos;
            //setXPos(x + velocity);
            this.XPos += velocity;
            //If player moves left, set X position to decrement by players velocity
        } else if (isMovingLeft){
            //double x = this.XPos;
            //setXPos(x - velocity);
            this.XPos -= velocity;
            if(this.XPos <= 0){ //Handles left border
                //setXPos(0);
                this.XPos = 0;
            }
        } else {
            //isStopped, stay as is
        }

        //jumping
        /*The following code was created with help from a tutorial on this site:
         * https://www.instructables.com/id/2D-Jumping-Tutorial-in-Java/
         * Accessed: 29/09/2019
         */
        if(isJumping || !onGround || onPlatform){
            isJumping = true;
            y -= jumpStrength;
            jumpStrength -= weight;
            System.out.println("jumpstrength: " + jumpStrength);
            setYPos(y);

            if(y <= floorheight - playerHeight*.45){
                onGround = false;
            } else {
                onGround = true;
                onPlatform = false;
                y = floorheight - playerHeight*.45;
                setYPos(y);
                isJumping = false;
                jumpStrength = 5;
            }
        }
        /*END */
    }
    @Override
    public void handleCollision(IEntity entity){
        this.YPos = entity.getYPos() - playerHeight*.4;
        isJumping = false; //only allows jump sound
        onPlatform = true;
    }

    @Override
    public void dies(){

    }

    @Override
    public String toString(){
        return "player";
    }
}
