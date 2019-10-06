package stickman.model;

import javafx.scene.text.Text;

/**
 * Implements Entity interface.
 * Represents an Entity in a level.
 * There can only be one player.
 */
public class Player implements Entity, Controllable {
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
    private int numLives;
    private double velocity;
    private Layer layer = Layer.FOREGROUND;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isJumping;
    private boolean isStopped;
    private boolean isFacingRight;

    private double floorheight = 350;
    private double jumpStrength = 12;
    private double weight = 0.5;

    private boolean win = false;
    private boolean lose = false;


    /**
     * Creates a new player and sets booleans for movement.
     */
    public Player(){

        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isJumping = false;
        this.isStopped = true;
        this.isFacingRight = true;
    }

    /**
     * Loops through images at a slower pace than tick.
     * Images change based on which direction Player is facing.
     * @return
     */
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

    @Override
    public void setXPos(double xpos){
        this.XPos = xpos;
    }

    @Override
    public void setYPos(double ypos){
        this.YPos = ypos;
    }

    @Override
    public void setHeight(double playerHeight){
        this.playerHeight = playerHeight;
    }

    @Override
    public void setWidth(double playerWidth){
        this.playerWidth = playerWidth;
    }

    /**
     * Gets the start X Position of player. This is taken from the
     * JSON config file.
     * @return The configured start X Position.
     */
    public double getStartXPos(){return this.startXPos;}

    /**
     * Gets the speed of the player.
     * @return The speed.
     */
    public double getVelocity(){
        return this.velocity;
    }

    /**
     * Gets the jump strength for the player at the current moment.
     * @return The current strength of the players jump (can be positive
     * or negative).
     */
    public double getJumpStrength(){
        return this.jumpStrength;
    }

    /**
     * Changes the players speed.
     * @param velocity The new speed the player should move.
     */
    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    /**
     * Sets the players starting X Position. This is given from the JSON
     * config file.
     * @param startXPos The given starting X Position for the player.
     */
    public void setStartXPos(double startXPos){
        this.startXPos = startXPos;
    }

    /**
     * Sets the number of lives of the player from the JSON config file.
     * @param numLives The number of lives a player has for a level.
     */
    public void setNumLives(int numLives){
        this.numLives = numLives;
    }

    /**
     * This gets the current number of lives the player has left.
     * @return The number of lives the player currently has.
     */
    public int getNumLives(){
        return this.numLives;
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
        double y = this.YPos;
        if(isMovingRight){
            this.XPos += velocity;
        }
        if (isMovingLeft) {
            this.XPos -= velocity;
            if (this.XPos <= 0) { //Handles left border
                this.XPos = 0;
            }
        }
        if(isJumping){
            y -= jumpStrength;
            jumpStrength -= weight;
            setYPos(y);
            if(y > floorheight-playerHeight*.4){ //Land on floor
                y = floorheight-playerHeight*.4;
                setYPos(y);
                isJumping = false;
                jumpStrength = 12;
            }
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
            }
        }
    }

    @Override
    public void handleCollision(Entity entity){
        this.YPos = entity.getYPos() - playerHeight*.4;
        isJumping = false;
        jumpStrength = 12;
    }

    @Override
    public String toString(){
        return "player";
    }

    /**
     * Sets boolean for winning the game.
     * @param win True if won, false if not.
     */
    public void setWin(boolean win){
        this.win = win;
    }

    /**
     * Checks if player has won the game.
     * @return True if won, false if not.
     */
    public boolean win(){
        if(win){
            return true;
        }
        return false;
    }

    /**
     * Player loses a life.
     */
    public void death(){
        numLives--;
        if(numLives <= 0){
            numLives = 0;
            lose = true;
        }
    }

    /**
     * Checks if player lost the game.
     * @return True if lost, false if not.
     */
    public boolean checkLose(){
        if (lose){
            return true;
        }
        return false;
    }
}

