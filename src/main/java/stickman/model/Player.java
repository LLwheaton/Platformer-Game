package stickman.model;

/**
 * Implements Entity interface.
 * Represents an Entity in a level.
 * There can only be one player.
 */
public class Player implements Entity {
    public String imagePath;
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
     * @param imagePath The image of the player to be used.
     * @param xpos The starting X position of the player in the Game Window.
     * @param ypos The starting Y position of the player in the Game Window.
     * @param height The height of the player in pixels.
     * @param width The width of the player in pixels.
     * @param velocity The speed the player will move.
     */
    public Player(String imagePath, double xpos, double ypos, double height, double width, double velocity){
        this.imagePath = imagePath;
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
        return  this.imagePath;
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

}
