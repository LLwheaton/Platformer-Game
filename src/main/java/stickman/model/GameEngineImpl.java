package stickman.model;
import java.util.ArrayList;
import java.util.List;

/**Implements the GameEngine interface.*/
public class GameEngineImpl implements stickman.model.GameEngine{
    private Level levelone;

    /**
     * Creates new GameEngine with the json config file.
     * Initialises GameConfig and passes JSON file to be parsed.
     * Sets current level to level created in GameConfig.
     * @param filename The json config file path
     */
    public GameEngineImpl(String filename){
        GameConfig gc = new GameConfig(filename);
        this.levelone = gc.getCurrentLevel();
    }

    @Override
    public Level getCurrentLevel(){
        return this.levelone;
    }

    @Override
    public void startLevel(){

    }

    @Override
    public boolean jump(){
        if(getCurrentLevel().jump()){
            return true;
        }
        return false;
    }

    @Override
    public boolean moveLeft(){
        if(getCurrentLevel().moveLeft()){
            return true;
        }
        return false;
    }

    @Override
    public boolean moveRight(){
        if(getCurrentLevel().moveRight()){
            return true;
        }
        return false;
    }

    @Override
    public boolean stopMoving(){
        if(getCurrentLevel().stopMoving()){
            return true;
        }
        return false;
    }

    @Override
    public void tick(){
        getCurrentLevel().tick();
    }
}
