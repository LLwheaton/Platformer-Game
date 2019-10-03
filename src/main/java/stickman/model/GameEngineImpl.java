package stickman.model;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**Implements the GameEngine interface.*/
public class GameEngineImpl implements stickman.model.GameEngine{
    private String filename;
    private double playerHeight;
    private double playerWidth;
    private double XPos;
    private double cloudVelocity;
    private Level levelone;
    private List<IEntity> entities;

    /**
     * Creates new GameEngine with the json config file.
     * @param filename The json config file path
     */
    public GameEngineImpl(String filename){
        //this.filename = filename;
        //extractJson(filename);
        GameConfig gc = new GameConfig(filename);
        //game config can create entities and send back a list
        //so that list can be used to create the level here..
        entities = new ArrayList<>();
        this.entities = gc.getEntities();
        this.levelone = gc.getCurrentLevel();
        //this.levelone = levelone;
    }

//    /**
//     * Reads in json file and stores its information
//     * after parsing.
//     * @param filename The json file to be parsed.
//     */
//    private void extractJson(String filename){
//
//        /*
//        CODE BELOW WRITTEN WITH HELP FROM:
//        https://howtodoinjava.com/library/json-simple-read-write-json-examples/
//        ACCESSED 06/09
//         */
//        JSONParser jsonParser = new JSONParser();
//        try(FileReader reader = new FileReader(filename)){
//            Object obj = jsonParser.parse(reader);
//            JSONObject jo = (JSONObject)obj;
//
//            String size = (String)jo.get("stickmanSize");
//            if(size.toLowerCase().equals("tiny")){
//                this.playerHeight = 40.0;
//                this.playerWidth = 12.0;
//            } else if(size.toLowerCase().equals("normal")){
//                this.playerHeight = 75.0;
//                this.playerWidth = 20.0;
//            } else if(size.toLowerCase().equals("large")){
//                this.playerHeight = 110.0;
//                this.playerWidth =  30.0;
//            } else if(size.toLowerCase().equals("giant")){
//                this.playerHeight = 160.0;
//                this.playerWidth = 42.0;
//            } else { //This should never happen if json file is correct
//                //Set to normal
//                System.out.println("Unable to get proper size. Default: Normal");
//                this.playerHeight = 40.0;
//                this.playerWidth = 12.0;
//            }
//            this.cloudVelocity = (double)jo.get("cloudVelocity");
//            JSONObject spos = (JSONObject)jo.get("stickmanPos");
//            this.XPos = (double)spos.get("x");
//        } catch(IOException | ParseException e){
//            e.printStackTrace();
//        }
//        /* END */
//        levelone = new LevelOne(600,380, this.playerHeight, this.playerWidth, this.XPos, this.cloudVelocity);
//    }

    /**
     * Gets current level
     * @return The level created and being used for stage one.
     */
    @Override
    public Level getCurrentLevel(){
        return levelone;

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
