package stickman.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameConfig {

    private String stickmanSize;
    private double playerHeight;
    private double playerWidth;
    private double startXPos;
    private double cloudVelocity;
    private double finishLine;

    private List<IEntity> entities = new ArrayList<>();
    private IEntity player;
    private Level levelone;
    private double floorHeight = 350;

    private EntityFactory factory = new EntityFactory();


    public GameConfig(String fileName){

        extract(fileName);
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
            JSONObject file = (JSONObject)obj;

            createFinishLine(file);
            IEntity player = createStickMan(file);
            createClouds(file);
            createPlatforms(file);
            createTrees(file);
            createEnemies(file);
            createCoins(file);

            createLevel((Player)player);

        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
        /* END */

    }

    private void createLevel(Player player){
        Level levelone = new LevelOne(600,380, player, this.entities);
        this.levelone = levelone;
    }

    public Level getCurrentLevel(){
        return this.levelone;
    }

    private void createFinishLine(JSONObject file){

        this.finishLine = (double)file.get("finishLine");
        IEntity finishLine = new FinishLine();
        finishLine.setXPos(this.finishLine);
        finishLine.setYPos(333);
        finishLine.setHeight(20);
        finishLine.setWidth(40);
        entities.add(finishLine);
    }

    private IEntity createStickMan(JSONObject file){
        //Stickman
        JSONObject stickman = (JSONObject)file.get("stickman");
        this.startXPos = (double)stickman.get("x");
        this.stickmanSize = (String)stickman.get("stickmanSize");
        double velocity = (double)stickman.get("velocity");
        double lives = (double)stickman.get("lives");
        determineSize(this.stickmanSize);
        IEntity player = factory.createEntity("player");
        player.setXPos(this.startXPos);
        player.setYPos(floorHeight);
        player.setHeight(this.playerHeight);
        player.setWidth(this.playerWidth);
        Player player2 = (Player)player; //CASTING UGH
        player2.setVelocity(velocity);
        player2.setNumLives((int)lives);
        entities.add(player);
        return player;
    }

    private void createClouds(JSONObject file){
        //Clouds
        JSONObject clouds = (JSONObject)file.get("clouds");
        double numClouds = (double)clouds.get("num");
        JSONArray cloudPositions = (JSONArray)clouds.get("position");
        for(int i = 0; i < (int)numClouds; i++){
            JSONObject pos = (JSONObject)cloudPositions.get(i);
            double x = (double)pos.get("x");
            double y = (double)pos.get("y");
            double cloudVelocity = (double)pos.get("velocity");
            IEntity cloud = factory.createEntity("cloud");
            cloud.setXPos(x);
            cloud.setYPos(y);
            cloud.setHeight(50.0);
            cloud.setWidth(80.0);
            Cloud cloud1 = (Cloud)cloud; //Shouldn't be doing this :/
            cloud1.setCloudVelocity(cloudVelocity);
            entities.add(cloud);
        }
    }

    private void createPlatforms(JSONObject file){
        //Platforms
        JSONObject platforms = (JSONObject)file.get("platforms");
        double numPlatforms = (double)platforms.get("num");
        JSONArray platformPositions = (JSONArray)platforms.get("position");
        for(int i = 0; i < numPlatforms; i++){
            JSONObject pos = (JSONObject)platformPositions.get(i);
            double x = (double)pos.get("x");
            double y = (double)pos.get("y");
            IEntity platform = factory.createEntity("platform");
            platform.setXPos(x);
            platform.setYPos(y);
            platform.setHeight(70.0);
            platform.setWidth(70.0);
            entities.add(platform);
        }
    }

    private void createTrees(JSONObject file){
        //Trees
        JSONObject trees = (JSONObject)file.get("trees");
        double numTrees = (double)trees.get("num");
        JSONArray treePositions = (JSONArray) trees.get("position");
        for(int i = 0; i < numTrees; i++){
            JSONObject pos = (JSONObject)treePositions.get(i);
            double x = (double)pos.get("x");
            double y = (double)pos.get("y");
            IEntity tree = factory.createEntity("tree");
            tree.setXPos(x);
            tree.setYPos(y);
            tree.setHeight(100.0);
            tree.setWidth(100.0);
            entities.add(tree);
        }
    }

    private void createEnemies(JSONObject file){
        //Enemies
        JSONObject enemies = (JSONObject)file.get("enemies");
        double numEnemies = (double)enemies.get("num");
        JSONArray enemyPositions = (JSONArray) enemies.get("position");
        for(int i = 0; i < numEnemies; i++){
            JSONObject pos = (JSONObject)enemyPositions.get(i);
            double x = (double)pos.get("x");
            double y = (double)pos.get("y");
            double enemyVelocity = (double)pos.get("velocity");
            IEntity slime = factory.createEntity("slime");
            slime.setXPos(x);
            slime.setYPos(y);
            slime.setHeight(30.0);
            slime.setWidth(30.0);
            Slime slime2 = (Slime)slime;
            slime2.setVelocity(enemyVelocity);
            entities.add(slime);
        }
    }

    private void createCoins(JSONObject file){
        //Coins
        JSONObject coins = (JSONObject)file.get("coins");
        double numCoins = (double)coins.get("num");
        JSONArray coinPositions = (JSONArray) coins.get("position");
        for(int i = 0; i < numCoins; i++){
            JSONObject pos = (JSONObject)coinPositions.get(i);
            double x = (double)pos.get("x");
            double y = (double)pos.get("y");
            IEntity coin = factory.createEntity("coin");
            coin.setXPos(x);
            coin.setYPos(y);
            coin.setHeight(20.0);
            coin.setWidth(20.0);
            entities.add(coin);
        }
    }

    private void determineSize(String size){
        switch (size.toLowerCase()){
            case "tiny":
                this.playerHeight = 40.0;
                this.playerWidth = 12.0;
                break;
            case "normal":
                this.playerHeight = 75.0;
                this.playerWidth = 20.0;
                break;
            case "large":
                this.playerHeight = 110.0;
                this.playerWidth =  30.0;
                break;
            case "giant":
                this.playerHeight = 160.0;
                this.playerWidth = 42.0;
                break;
            default:
                throw new IllegalArgumentException("Valid size not given");
        }
    }


}
