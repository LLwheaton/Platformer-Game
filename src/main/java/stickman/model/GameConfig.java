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

    PlayerFactory playerFactory = new PlayerFactory();
    CloudFactory cloudFactory = new CloudFactory();
    CoinFactory coinFactory = new CoinFactory();
    SlimeFactory slimeFactory = new SlimeFactory();
    PlatformFactory platformFactory = new PlatformFactory();
    TreeFactory treeFactory = new TreeFactory();


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
            JSONObject file = (JSONObject)obj;

            //Finish Line
            this.finishLine = (double)file.get("finishLine");
            IEntity finishLine = new FinishLine(this.finishLine, 333, 20, 40);
            entities.add(finishLine);

            //Stickman
            JSONObject stickman = (JSONObject)file.get("stickman");
            this.startXPos = (double)stickman.get("x");
            this.stickmanSize = (String)stickman.get("stickmanSize");
            double velocity = (double)stickman.get("velocity");
            determineSize(this.stickmanSize);
            IEntity player = playerFactory.createEntity(this.startXPos, floorHeight, this.playerHeight, this.playerWidth);
            Player player2 = (Player)player; //CASTING BAD UGHH
            player2.setVelocity(velocity);
            entities.add(player);

            //Clouds
            JSONObject clouds = (JSONObject)file.get("clouds");
            //System.out.println("OBJECT" + clouds.get("num"));
            double numClouds = (double)clouds.get("num");
            JSONArray cloudPositions = (JSONArray)clouds.get("position");
            for(int i = 0; i < (int)numClouds; i++){
                JSONObject pos = (JSONObject)cloudPositions.get(i);
                double x = (double)pos.get("x");
                double y = (double)pos.get("y");
                double cloudVelocity = (double)pos.get("velocity");
                IEntity cloud = cloudFactory.createEntity(x, y, 50.0,80.0);
                Cloud cloud1 = (Cloud)cloud; //Shouldn't be doing this :/
                cloud1.setCloudVelocity(cloudVelocity);
                entities.add(cloud);
            }
            //JSONObject pos = (JSONObject)cloudPositions.get(0);
            //double xpos = (double)pos.get("x");
            //System.out.println(xpos);

            //Platforms
            JSONObject platforms = (JSONObject)file.get("platforms");
            double numPlatforms = (double)platforms.get("num");
            JSONArray platformPositions = (JSONArray)platforms.get("position");
            for(int i = 0; i < numPlatforms; i++){
                JSONObject pos = (JSONObject)platformPositions.get(i);
                double x = (double)pos.get("x");
                double y = (double)pos.get("y");
                IEntity platform = platformFactory.createEntity(x, y, 70.0,70.0);
                entities.add(platform);
            }

            //Trees
            JSONObject trees = (JSONObject)file.get("trees");
            double numTrees = (double)trees.get("num");
            JSONArray treePositions = (JSONArray) trees.get("position");
            for(int i = 0; i < numTrees; i++){
                JSONObject pos = (JSONObject)treePositions.get(i);
                double x = (double)pos.get("x");
                double y = (double)pos.get("y");
                IEntity tree = treeFactory.createEntity(x, y, 100.0,100.0);
                entities.add(tree);
            }

            //Enemies
            JSONObject enemies = (JSONObject)file.get("enemies");
            double numEnemies = (double)enemies.get("num");
            JSONArray enemyPositions = (JSONArray) enemies.get("position");
            for(int i = 0; i < numEnemies; i++){
                JSONObject pos = (JSONObject)enemyPositions.get(i);
                double x = (double)pos.get("x");
                double y = (double)pos.get("y");
                double enemyVelocity = (double)pos.get("velocity");
                IEntity slime = slimeFactory.createEntity(x, y, 30.0,30.0);
                Slime slime2 = (Slime)slime;
                slime2.setVelocity(enemyVelocity);
                entities.add(slime);
            }

            //Coins
            JSONObject coins = (JSONObject)file.get("coins");
            double numCoins = (double)coins.get("num");
            JSONArray coinPositions = (JSONArray) coins.get("position");
            for(int i = 0; i < numCoins; i++){
                JSONObject pos = (JSONObject)coinPositions.get(i);
                double x = (double)pos.get("x");
                double y = (double)pos.get("y");
                IEntity coin = coinFactory.createEntity(x, y, 20.0,20.0);
                entities.add(coin);
            }

            createLevel((Player)player);



        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
        /* END */

    }
    private void createEntities(){ //calls to factory somehow?
        //Player player = new Player(this.startXPos, floorHeight, this.playerHeight, this.playerWidth);
        //IEntity player = playerFactory.createEntity(this.startXPos, floorHeight, this.playerHeight, this.playerWidth);
        //Cloud cloud1 = new Cloud(150.0, 150.0, 50.0, 80.0);
        //Cloud cloud2 = new Cloud(500.0, 50.0, 50.0, 80.0);
        //Platform platform = new Platform(250, floorHeight-100, 70, 70);
        //Platform platform2 = new Platform(400, floorHeight-80, 40,40);
//        Slime redSlime = new Slime(900, floorHeight-10, 30, 30);
//        Slime blueSlime = new Slime(950, floorHeight-10, 30, 30);
//        Slime greenSlime = new Slime(1000, floorHeight-10, 30, 30);
//        Slime yellowSlime = new Slime(1050, floorHeight-10, 30, 30);
//        Slime purpleSlime = new Slime(1100, floorHeight-10, 30, 30);
//        Tree tree = new Tree(500, floorHeight-90, 100,100);
//        Coin coin = new Coin(260,175,20,20);
        //FinishLine finish = new FinishLine(500.0, 333, 20, 40);
        //this.entities.add(player);
        //this.entities.add(cloud1);
        //this.entities.add(cloud2);
        //this.entities.add(platform);
        //this.entities.add(platform2);
//        this.entities.add(redSlime);
//        this.entities.add(blueSlime);
//        this.entities.add(greenSlime);
//        this.entities.add(yellowSlime);
//        this.entities.add(purpleSlime);
//        this.entities.add(tree);
//        this.entities.add(coin);
        ///this.entities.add(finish);
        //createLevel((Player)player);
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

    public IEntity factory(){

        return null;
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
