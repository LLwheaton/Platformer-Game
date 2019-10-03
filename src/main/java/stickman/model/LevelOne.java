package stickman.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Implements the Level interface.
 * This is the current and only level for stage one.
 * All entities are created in this class.
 * Movement of player and tick functions are implemented here.
 */
public class LevelOne implements Level {
    private double height;
    private double width;
    private Player player;
    private List<IEntity> entities = new ArrayList<>();
    //private Player player = new Player( 20, 350, 75, 15, 1.0);
//    private Cloud cloud1 = new Cloud("cloud_2.png", 150.0, 150.0, 50.0, 80.0, 1);
//    private Cloud cloud2 = new Cloud("cloud_2.png", 500.0, 50.0, 50.0, 80.0, 1);
    //private Slime slime = new Slime(200, height + 330, 30, 30);
    //private Platform platform = new Platform(250, height+270, 70, 70);
    private boolean onGround = true;
    private final double MAXJUMPHEIGHT = 100;
    private boolean reachedTop = false;

    private double gravity = 34;
    private double floorheight;
    private double jumpStrength = 5;
    private double weight = 0.1;

    /**
     * Creates the level and sets player and cloud parameters.
     * @param width The width of the level in pixels.
     * @param height The height of the level in pixels.
//     * @param playerHeight The height of player in pixels.
//     * @param playerWidth The width of player in pixels.
//     * @param XPos The X position of player in pixels.
//     * @param cloudVelocity The velocity of cloud entities.
     */
    public LevelOne(double width, double height, Player player, List<IEntity> entities){
        this.width = width;
        this.height = height;
        this.entities = entities;
        this.player = player;
        //this.player.setHeight(playerHeight);
        //this.player.setXPos(XPos);
        //this.player.setWidth(playerWidth);
        //this.player.setYPos(height - 30 - (playerHeight*0.45));
        //this.player.setYPos(height - 64); //added
        //this.cloud1.setCloudVelocity(cloudVelocity);
        //this.cloud2.setCloudVelocity(cloudVelocity);
    }

    /**
     * Creates array list and adds all created entities to list.
     * @return The list with all created entities.
     */
    @Override
    public List<IEntity> getEntities() {
//        List<IEntity> entities = new ArrayList<>();
//        entities.add(this.player);
//        entities.add(this.cloud1);
//        entities.add(this.cloud2);
//        //entities.add(this.slime);
//        entities.add(this.platform);
        return this.entities;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    /**
     * Sets the clouds speed.
     * Handles player movement.
     */
    @Override
    public void tick() {
        for(IEntity entity : entities){
                   entity.update();
        }
        //floorheight = height - 64; //added


//        double y = player.getYPos(); //added
//        //cloud1.setXPos(cloud1.getXPos() - (cloud1.getCloudVelocity()/60));
//        //cloud2.setXPos(cloud2.getXPos() - (cloud2.getCloudVelocity()/60));
//
//        //If player moves right, set X position to increment by players velocity
//        if(player.isMovingRight()){
//            double x = getHeroX();
//            player.setXPos(x + player.getVelocity());
//        //If player moves left, set X position to decrement by players velocity
//        } else if (player.isMovingLeft()){
//            double x = getHeroX();
//            player.setXPos(x - player.getVelocity());
//            if(player.getXPos() <= 0){ //Handles left border
//                player.setXPos(0);
//            }
//        //If player stops moving, set X position to players current X location/
//        } else if(player.isStopped()){
//            player.setXPos(getHeroX());
//        }
//
//        //jumping
//        /*The following code was created with help from a tutorial on this site:
//        * https://www.instructables.com/id/2D-Jumping-Tutorial-in-Java/
//        * Accessed: 29/09/2019
//         */
//        if(player.isJumping() || !onGround){
//            player.setIsJumping(true);
//            y -= jumpStrength;
//            jumpStrength -= weight;
//            player.setYPos(y);
//
//            if(y <= floorheight){
//                onGround = false;
//            } else {
//                onGround = true;
//                y = floorheight;
//                player.setYPos(y);
//                player.setIsJumping(false);
//                jumpStrength = 5;
//            }
//        }
//        /*END */
    }

    @Override
    public double getFloorHeight() {
        return this.height - 30;
    }

    @Override
    public double getHeroX() {
        return player.getXPos();
    }

    @Override
    public boolean jump() {
        return player.jump();
    }

    @Override
    public boolean moveLeft() {
        return player.moveLeft();
    }
    /*This can only happen if they are not currently moving right (but mid-jump is ok)*/
    @Override
    public boolean moveRight() {
        return player.moveRight();
    }
    /* Tells the hero to stop moving left or right.
     * This can only happen if they are currently moving - mid-jump is ok.
     * This should not effect the jump itself.*/
    @Override
    public boolean stopMoving() {
        return player.stopMoving();
    }
}
