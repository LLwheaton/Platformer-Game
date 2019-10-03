package stickman.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameConfig {

    private String stickmanSize;
    private double startXPos;
    private double cloudVelocity;

    private List<IEntity> entities = new ArrayList<>();
    private IEntity player;
    private Level levelone;
    private double floorHeight = 350;

    public GameConfig(String fileName){

        extract(fileName);
        createEntities();
    }
    /**
     * Reads in json file and stores its information
     * after parsing.
     * @param filename The json file to be parsed.
     */
    private void extract(String filename){

        /*
        CODE BELOW WRITTEN WITH HELP FROM:
        https://howtodoinjava.com/library/json-simple-read-write-json-examples/
        ACCESSED 06/09
         */
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(filename)){
            Object obj = jsonParser.parse(reader);
            JSONObject jo = (JSONObject)obj;
            this.stickmanSize = (String)jo.get("stickmanSize");
            this.cloudVelocity = (double)jo.get("cloudVelocity");
            JSONObject spos = (JSONObject)jo.get("stickmanPos");
            this.startXPos = (double)spos.get("x");
        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
        /* END */

    }
    private void createEntities(){
        Player player = new Player(this.startXPos, floorHeight, this.stickmanSize);
        Cloud cloud1 = new Cloud("cloud_2.png", 150.0, 150.0, 50.0, 80.0, cloudVelocity);
        Cloud cloud2 = new Cloud("cloud_2.png", 500.0, 50.0, 50.0, 80.0, cloudVelocity);
        Platform platform = new Platform(250, floorHeight-100, 70, 70);
        Slime slime = new Slime(200, floorHeight-10, 30, 30);
        this.entities.add(player);
        this.entities.add(cloud1);
        this.entities.add(cloud2);
        this.entities.add(platform);
        this.entities.add(slime);
        createLevel(player);
    }
    private void createLevel(Player player){
        Level levelone = new LevelOne(600,380, player, this.entities);
        this.levelone = levelone;
    }
    public List<IEntity> getEntities(){
        return this.entities;
    }
    public Level getCurrentLevel(){
        return this.levelone;
    }

    public String getStickmanSize(){
        return this.stickmanSize;
    }
    public double getStartXPos(){
        return this.startXPos;
    }
    public double getCloudVelocity(){
        return this.cloudVelocity;
    }


}
