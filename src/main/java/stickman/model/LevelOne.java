package stickman.model;

import javafx.scene.text.Text;

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
    private List<IEntity> entities;

    /**
     * Creates the level and sets player and cloud parameters.
     * @param width The width of the level in pixels.
     * @param height The height of the level in pixels.
     * @param player The player being used in the level.
     * @param entities The list of entities for the current level.
     */
    public LevelOne(double width, double height, Player player, List<IEntity> entities){
        this.width = width;
        this.height = height;
        this.entities = entities;
        this.player = player;
        Text text = new Text();
        text.setText("Lives: ");
        text.setX(5);
        text.setY(20);
    }

    /**
     * Creates array list and adds all created entities to list.
     * @return The list with all created entities.
     */
    @Override
    public List<IEntity> getEntities() {
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

            if(entity.toString().equals("slime")){
                //if(checkIntersect(player, entity) && player.getJumpStrength() < 0){
                if(checkIntersect(player, entity)){
                    if(player.getJumpStrength() < 0){
                        this.entities.remove(entity);
                        //entity.dies();
                        break;
                    } else { //use handle collision?
                        player.setXPos(player.getStartXPos());
                        //player.setJumpStrength(5);
                    }
                    //entity.handleCollision();
                    //this.entities.remove(entity);
                    break; //this actually worked? lol
                }
            } else if(entity.toString().equals("platform")){
                //System.out.println("intersect?: " + checkIntersect(player, entity));
                //System.out.println("velocity: " + player.getVelocity());
                if(checkIntersect(player, entity) && player.getJumpStrength() < 0){

                    player.handleCollision(entity);
                }
            }
        }
    }

    public boolean checkIntersect(IEntity a, IEntity b){
        double ax = a.getXPos();
        double ay = a.getYPos();
        double awidth = a.getWidth();
        double aheight = a.getHeight();
        double bx = b.getXPos();
        double by = b.getYPos();
        double bwidth = b.getWidth();
        double bheight = b.getHeight();
        return (ax < (bx + bwidth)) &&
                ((ax + awidth) > bx) &&
                (ay - a.getHeight()*.45 < (by + bheight)) &&
                ((ay - a.getHeight()*.45 + aheight) > by);
    }

    public boolean checkTopIntersect(IEntity a, IEntity b){
        double ax = a.getXPos();
        double ay = a.getYPos();
        double awidth = a.getWidth();
        double aheight = a.getHeight();
        double bx = b.getXPos();
        double by = b.getYPos();
        double bwidth = b.getWidth();
        double bheight = b.getHeight();
        return (ax < (bx + bwidth)) &&
                ((ax + awidth) > bx) &&
                (ay < (by + bheight)) &&
                ((ay + aheight) > by);
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
