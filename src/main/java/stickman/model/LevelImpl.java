package stickman.model;


import javafx.scene.text.Font;
import javafx.scene.text.Text;
import stickman.view.GameWindow;

import java.util.List;

/**
 * Implements the Level interface.
 * This is the current and only level for stage one.
 * All entities are created in this class.
 * Movement of player and tick functions are implemented here.
 */
public class LevelImpl implements Level {
    private double height;
    private double width;
    private Player player;
    private List<Entity> entities;


    /**
     * Creates the level and sets player and cloud parameters.
     * @param width The width of the level in pixels.
     * @param height The height of the level in pixels.
     * @param player The player being used in the level.
     * @param entities The list of entities for the current level.
     */
    public LevelImpl(double width, double height, Player player, List<Entity> entities){
        this.width = width;
        this.height = height;
        this.entities = entities;
        this.player = player;
    }

    /**
     * Creates array list and adds all created entities to list.
     * @return The list with all created entities.
     */
    @Override
    public List<Entity> getEntities() {
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

        for(Entity entity : entities){
            entity.update();
            if(entity.toString().equals("slime")){
                if(checkIntersect(player, entity)){
                    if(player.getJumpStrength() < 0){
                        this.entities.remove(entity);
                        break;
                    } else {
                        player.death();
                        if(player.checkLose()){
                            break;
                        }
                        player.setXPos(player.getStartXPos());
                        entity.handleCollision(player);
                    }
                }
            } else if(entity.toString().equals("platform")){
                handlePlatform(player, entity);
            } else if(entity.toString().equals("coin")){
                if(checkIntersect(player, entity)){
                    this.entities.remove(entity);
                    break;
                }
            } else if(entity.toString().equals("finish")){
                if(checkFinish(player, entity)){
                    player.setXPos(entity.getXPos());
                    player.setWin(true);
                    break;
                }
            }
        }
        if(player.win()){
            winScreen();
        }
        if(player.checkLose()){
            loseScreen();
        }
    }

    public boolean checkIntersect(Entity a, Entity b){
        double buffer = a.getHeight()*.45;
        return (a.getXPos() < (b.getXPos() + b.getWidth())) &&
                ((a.getXPos() + a.getWidth()) > b.getXPos()) &&
                (a.getYPos() - buffer < (b.getYPos() + b.getHeight())) &&
                ((a.getYPos() - buffer + a.getHeight()) > b.getYPos());
    }

    public boolean checkFinish(Entity a, Entity b){
        return (a.getXPos() < (b.getXPos() + b.getWidth())) &&
                ((a.getXPos() + a.getWidth()) > b.getXPos());
    }

    public void winScreen(){

        Text text = new Text( 150,200, "YOU WIN");
        text.setFont(new Font(80));
        GameWindow.getPane().getChildren().add(text);
    }

    public void loseScreen(){
        Text text = new Text( 150,200, "YOU LOSE");
        text.setFont(new Font(80));
        GameWindow.getPane().getChildren().add(text);
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

    public void handlePlatform(Player player, Entity platform){
        if(checkIntersect(player, platform) && player.getJumpStrength() < 0){
            player.handleCollision(platform);
        }
    }
}
