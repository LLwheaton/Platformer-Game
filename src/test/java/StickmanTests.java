import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import stickman.App;
import stickman.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StickmanTests {

    //Cloud testing////////////////////////////////////////////////////////
    @Test
    public void cloudTest() {
        Cloud cloud = new Cloud();
        String image = cloud.getImagePath();
        assertEquals("cloud_2.png", image);
    }
    @Test
    public void cloudHeightTest(){
        Cloud cloud = new Cloud();
        cloud.setHeight(50);
        double height = cloud.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void cloudWidthTest(){
        Cloud cloud = new Cloud();
        cloud.setWidth(50);
        double width = cloud.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void cloudXTest(){
        Cloud cloud = new Cloud();
        cloud.setXPos(50);
        double xpos = cloud.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void cloudYTest(){
        Cloud cloud = new Cloud();
        cloud.setYPos(50);
        double ypos = cloud.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void cloudLayerTest(){
        Cloud cloud = new Cloud();
        IEntity.Layer layer = cloud.getLayer();
        assertEquals(IEntity.Layer.BACKGROUND, layer);
    }
    @Test
    public void cloudUpdateTest(){
        Cloud cloud = new Cloud();
        cloud.update();
    }
    @Test
    public void cloudCollisionTest(){
        Cloud cloud = new Cloud();
        cloud.handleCollision(cloud);
    }
    @Test
    public void cloudVelocityTest(){
        Cloud cloud = new Cloud();
        cloud.setCloudVelocity(35);
    }

    //Player testing/////////////////////////////////////////////////////////////
    @Test
    public void playerTest(){
        Player player = new Player();
        String image = player.getImagePath();
        assertEquals("ch_stand1.png", image);
    }
    @Test
    public void playerHeightTest(){
        Player player = new Player();
        player.setHeight(50);
        double height = player.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void playerWidthTest(){
        Player player = new Player();
        player.setWidth(50);
        double width = player.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void playerXTest(){
        Player player = new Player();
        player.setXPos(50);
        double xpos = player.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void playerYTest(){
        Player player = new Player();
        player.setYPos(50);
        double ypos = player.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void playerLayerTest(){
        Player player = new Player();
        IEntity.Layer layer = player.getLayer();
        assertEquals(IEntity.Layer.FOREGROUND, layer);
    }
    @Test
    public void playerCollisionTest(){
        Player player = new Player();
        //***************************************************
    }
    @Test
    public void playerVelocityTest(){
        Player player = new Player();
        player.setVelocity(3);
        double velocity = player.getVelocity();
        assertEquals(3, velocity, 0.1);
    }
    @Test
    public void playerUpdateTest(){
        Player player = new Player();
        //**************************************************************
    }
    @Test
    public void playerStartXPosTest(){
        Player player = new Player();
        player.setStartXPos(50);
        double x = player.getStartXPos();
        assertEquals(50, x, 0.1);
    }
    @Test
    public void playerJumpStrengthTest(){
        Player player = new Player();
        double j = player.getJumpStrength();
        assertEquals(12, j, 0.1);
    }
    @Test
    public void playerLivesTest(){
        Player player = new Player();
        player.setNumLives(6);
    }
    @Test
    public void playerDeathTest(){
        Player player = new Player();
        player.death();
    }
    @Test
    public void playerJumpTest(){
        Player player = new Player();
        boolean res = player.jump();
        assertTrue(res);
    }
    @Test
    public void playerLeftTest(){
        Player player = new Player();
        boolean res = player.moveLeft();
        assertTrue(res);
    }
    @Test
    public void playerRightTest(){
        Player player = new Player();
        boolean res = player.moveRight();
        assertTrue(res);
    }
    @Test
    public void playerStopMovingTest(){
        Player player = new Player();
        boolean res = player.stopMoving();
        assertTrue(!res);
    }

    //Coin testing///////////////////////////////////////////////////////////
    @Test
    public void coinTest(){
        Coin coin = new Coin();
        String image = coin.getImagePath();
        assertEquals("coin.png", image);
    }
    @Test
    public void coinHeightTest(){
        Coin coin = new Coin();
        coin.setHeight(50);
        double height = coin.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void coinWidthTest(){
        Coin coin = new Coin();
        coin.setWidth(50);
        double width = coin.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void coinXTest(){
        Coin coin = new Coin();
        coin.setXPos(50);
        double xpos = coin.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void coinYTest(){
        Coin coin = new Coin();
        coin.setYPos(50);
        double ypos = coin.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void coinLayerTest(){
        Coin coin = new Coin();
        IEntity.Layer layer = coin.getLayer();
        assertEquals(IEntity.Layer.FOREGROUND, layer);
    }
    @Test
    public void coinUpdateTest(){
        Coin coin = new Coin();
        coin.update();
    }
    @Test
    public void coinCollisionTest(){
        Coin coin = new Coin();
        coin.handleCollision(coin);
    }

    //Finish line testing///////////////////////////////////////////////////
    @Test
    public void finishLineTest(){
        FinishLine fl = new FinishLine();
        String image = fl.getImagePath();
        assertEquals("chest.png", image);
    }
    @Test
    public void finishLineHeightTest(){
        FinishLine fl = new FinishLine();
        fl.setHeight(50);
        double height = fl.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void finishLineWidthTest(){
        FinishLine fl = new FinishLine();
        fl.setWidth(50);
        double width = fl.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void finishLineXTest(){
        FinishLine fl = new FinishLine();
        fl.setXPos(50);
        double xpos = fl.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void finishLineYTest(){
        FinishLine fl = new FinishLine();
        fl.setYPos(50);
        double ypos = fl.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void finishLineLayerTest(){
        FinishLine fl = new FinishLine();
        IEntity.Layer layer = fl.getLayer();
        assertEquals(IEntity.Layer.FOREGROUND, layer);
    }
    @Test
    public void finishLineUpdateTest(){
        FinishLine fl = new FinishLine();
        fl.update();
    }
    @Test
    public void finishLineCollisionTest(){
        FinishLine fl = new FinishLine();
        fl.handleCollision(fl);
    }
    @Test
    public void finishLineToStringTest(){
        FinishLine fl = new FinishLine();
        String str = fl.toString();
        assertEquals("finish",str);
    }

    //Entity Factory testing/////////////////////////////////////////////////////
    @Test
    public void factorySlimeTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("slime");
        assertEquals("slime", entity.toString());
    }
    @Test
    public void factoryPlayerTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("player");
        assertEquals("player", entity.toString());
    }
    @Test
    public void factoryCloudTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("cloud");
        assertEquals("cloud", entity.toString());
    }
    @Test
    public void factoryCoinTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("coin");
        assertEquals("coin", entity.toString());
    }
    @Test
    public void factoryPlatformTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("platform");
        assertEquals("platform", entity.toString());
    }
    @Test
    public void factoryTreeTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("tree");
        assertEquals("tree", entity.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void factoryInvalidTypeTest(){
        EntityFactory f = new EntityFactory();
        IEntity entity = f.createEntity("something");
    }

    //GameConfig testing//////////////////////////////////////////////////

    //GameEngine testing///////////////////////////////////////////////////
    @Test
    public void gameEngineTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        Level level = ge.getCurrentLevel();
        ge.startLevel();
    }
    @Test
    public void gameEngineTickTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        ge.tick();
    }
    @Test
    public void gameEngineJumpTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        boolean res = ge.jump();
        assertTrue(res);
    }
    @Test
    public void gameEngineLeftTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        boolean res = ge.moveLeft();
        assertTrue(res);
    }
    @Test
    public void gameEngineRightTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        boolean res = ge.moveRight();
        assertTrue(res);
    }
    @Test
    public void gameEngineStopMovingTest(){
        GameEngineImpl ge = new GameEngineImpl("src\\main\\resources\\default.json");
        boolean res = ge.stopMoving();
        assertTrue(!res);
    }

    //Level testing////////////////////////////////////////////////////////

    //Platform testing//////////////////////////////////////////////////////

    @Test
    public void platformTest(){
        Platform p = new Platform();
        String image = p.getImagePath();
        assertEquals("platform.png", image);
    }
    @Test
    public void platformHeightTest(){
        Platform p = new Platform();
        p.setHeight(50);
        double height = p.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void platformWidthTest(){
        Platform p = new Platform();
        p.setWidth(50);
        double width = p.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void platformXTest(){
        Platform p = new Platform();
        p.setXPos(50);
        double xpos = p.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void platformYTest(){
        Platform p = new Platform();
        p.setYPos(50);
        double ypos = p.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void platformLayerTest(){
        Platform p = new Platform();
        IEntity.Layer layer = p.getLayer();
        assertEquals(IEntity.Layer.FOREGROUND, layer);
    }
    @Test
    public void PlatformUpdateTest(){
        Platform p = new Platform();
        p.update();
    }
    @Test
    public void platformCollisionTest(){
        Platform p = new Platform();
        p.handleCollision(p);
    }

    //Slime testing//////////////////////////////////////////////////////////
    @Test
    public void slimeTest(){
        Slime slime = new Slime();
        String image = slime.getImagePath();
        assertEquals("slimeRa.png", image);
    }
    @Test
    public void slimeHeightTest(){
        Slime slime = new Slime();
        slime.setHeight(50);
        double height = slime.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void slimeWidthTest(){
        Slime slime = new Slime();
        slime.setWidth(50);
        double width = slime.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void slimeXTest(){
        Slime slime = new Slime();
        slime.setXPos(50);
        double xpos = slime.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void slimeYTest(){
        Slime slime = new Slime();
        slime.setYPos(50);
        double ypos = slime.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void slimeLayerTest(){
        Slime slime = new Slime();
        IEntity.Layer layer = slime.getLayer();
        assertEquals(IEntity.Layer.FOREGROUND, layer);
    }
    @Test
    public void slimeUpdateTest(){
        Slime slime = new Slime();
        slime.update();
    }
    @Test
    public void slimeCollisionTest(){
        Slime slime = new Slime();
        slime.handleCollision(slime);
    }
    @Test
    public void slimeVelocityTest(){
        Slime slime = new Slime();
        slime.setVelocity(3);
    }
    @Test
    public void slimeUpdateTest2(){
        Slime slime = new Slime();
        double XPos = -2;
        slime.setXPos(XPos);
        slime.update();
        assertEquals(3500.0, slime.getXPos(), 0.1);
    }

    //Tree testing///////////////////////////////////////////////////////////
    @Test
    public void treeTest(){
        Tree tree = new Tree();
        String image = tree.getImagePath();
        assertEquals("tree2.png", image);
    }
    @Test
    public void treeHeightTest(){
        Tree tree = new Tree();
        tree.setHeight(50);
        double height = tree.getHeight();
        assertEquals(50.0, height, 0.1);
    }
    @Test
    public void treeWidthTest(){
        Tree tree = new Tree();
        tree.setWidth(50);
        double width = tree.getWidth();
        assertEquals(50.0, width, 0.1);
    }
    @Test
    public void treeXTest(){
        Tree tree = new Tree();
        tree.setXPos(50);
        double xpos = tree.getXPos();
        assertEquals(50.0, xpos, 0.1);
    }
    @Test
    public void treeYTest(){
        Tree tree = new Tree();
        tree.setYPos(50);
        double ypos = tree.getYPos();
        assertEquals(50.0, ypos, 0.1);
    }
    @Test
    public void treeLayerTest(){
        Tree tree = new Tree();
        IEntity.Layer layer = tree.getLayer();
        assertEquals(IEntity.Layer.BACKGROUND, layer);
    }
    @Test
    public void treeUpdateTest(){
        Tree tree = new Tree();
        tree.update();
    }
    @Test
    public void treeCollisionTest(){
        Tree tree = new Tree();
        tree.handleCollision(tree);
    }



}
