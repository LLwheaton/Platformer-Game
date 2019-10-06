import de.saxsys.javafx.test.JfxRunner;
import de.saxsys.javafx.test.TestInJfxThread;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.runner.RunWith;
import stickman.App;
import stickman.model.*;
import stickman.view.BlockedBackground;
import stickman.view.GameWindow;
import stickman.view.KeyboardInputHandler;
import stickman.view.ParallaxBackground;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JfxRunner.class)
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
        Entity.Layer layer = cloud.getLayer();
        assertEquals(Entity.Layer.BACKGROUND, layer);
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
        Entity.Layer layer = player.getLayer();
        assertEquals(Entity.Layer.FOREGROUND, layer);
    }
    @Test
    public void playerCollisionTest(){
        Player player = new Player();
        Slime slime = new Slime();
        player.setXPos(30);
        player.setYPos(30);
        slime.setYPos(30);
        slime.setXPos(30);
        player.handleCollision(slime);
    }
    @Test
    public void playerVelocityTest(){
        Player player = new Player();
        player.setVelocity(3);
        double velocity = player.getVelocity();
        assertEquals(3, velocity, 0.1);
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

    @Test
    public void playerGetLivesTest(){
        Player player = new Player();
        player.setNumLives(3);
        int res = player.getNumLives();
        assertEquals(3, res);
    }
    @Test
    public void playerSetWinTest(){
        Player player = new Player();
        player.setWin(true);
        boolean res = player.win();
        assertTrue(res);
    }
    @Test
    public void playerCheckLoseTest(){
        Player player = new Player();
        player.setNumLives(1);
        player.death();
        boolean res = player.checkLose();
        assertTrue(res);
    }
    @Test
    public void playerCheckLoseTest2(){
        Player player = new Player();
        player.setNumLives(3);
        player.death();
        player.death();
        boolean res = player.checkLose();
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
        Entity.Layer layer = coin.getLayer();
        assertEquals(Entity.Layer.FOREGROUND, layer);
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
        Entity.Layer layer = fl.getLayer();
        assertEquals(Entity.Layer.FOREGROUND, layer);
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
        Entity entity = f.createEntity("slime");
        assertEquals("slime", entity.toString());
    }
    @Test
    public void factoryPlayerTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("player");
        assertEquals("player", entity.toString());
    }
    @Test
    public void factoryCloudTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("cloud");
        assertEquals("cloud", entity.toString());
    }
    @Test
    public void factoryCoinTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("coin");
        assertEquals("coin", entity.toString());
    }
    @Test
    public void factoryPlatformTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("platform");
        assertEquals("platform", entity.toString());
    }
    @Test
    public void factoryTreeTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("tree");
        assertEquals("tree", entity.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void factoryInvalidTypeTest(){
        EntityFactory f = new EntityFactory();
        Entity entity = f.createEntity("something");
    }

    //GameConfig testing//////////////////////////////////////////////////
    @Test
    public void gameConfigTestTinySize(){
        GameConfig gc = new GameConfig("src\\main\\resources\\default.json");
        gc.determineSize("tiny");
    }
    @Test
    public void gameConfigTestLargeSize(){
        GameConfig gc = new GameConfig("src\\main\\resources\\default.json");
        gc.determineSize("large");
    }
    @Test
    public void gameConfigTestGiantSize(){
        GameConfig gc = new GameConfig("src\\main\\resources\\default.json");
        gc.determineSize("giant");
    }
    @Test(expected = IllegalArgumentException.class)
    public void gameConfigTestInvalidSize(){
        GameConfig gc = new GameConfig("src\\main\\resources\\default.json");
        gc.determineSize("something");
    }
    @Test
    public void gameConfigWrongFileTest(){
        GameConfig gc = new GameConfig("none");
    }


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
    @Test
    public void levelGetEntitiesTest(){
        Player player = new Player();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        LevelImpl level = new LevelImpl(600,380, player, entities);
        List<Entity> res = new ArrayList<>();
        res = level.getEntities();
        assertEquals(entities.get(0).toString(), res.get(0).toString());
    }
    @Test
    public void levelHeightTest(){
        Player player = new Player();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        LevelImpl level = new LevelImpl(600,380, player, entities);
        double height = level.getHeight();
        assertEquals(380, height, 0.1);
    }
    @Test
    public void levelWidthTest(){
        Player player = new Player();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        LevelImpl level = new LevelImpl(600,380, player, entities);
        double width = level.getWidth();
        assertEquals(600, width, 0.1);
    }
    @Test
    public void levelPlayerXTest(){
        Player player = new Player();
        player.setXPos(20);
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        LevelImpl level = new LevelImpl(600,380, player, entities);
        double xpos = level.getHeroX();
        assertEquals(20, xpos, 0.1);
    }
    @Test
    public void levelFloorHeightTest(){
        Player player = new Player();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        LevelImpl level = new LevelImpl(600,380, player, entities);
        double fh = level.getFloorHeight();
        assertEquals(350, fh, 0.1);
    }
    @Test
    public void levelIntersectTest(){
        Player player = new Player();
        player.setXPos(30);
        player.setXPos(30);
        Slime slime = new Slime();
        slime.setXPos(30);
        slime.setYPos(30);
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        entities.add(slime);
        LevelImpl level = new LevelImpl(600,380, player, entities);

        level.checkIntersect(player, slime);
    }
    @Test
    public void levelWinScreenTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        GameWindow gw = new GameWindow(ge, 600,400);
        Player player = new Player();
        List<Entity> list = new ArrayList<>();
        list.add(player);
        LevelImpl level = new LevelImpl(600,380, player, list);
        level.winScreen();
    }
    @Test
    public void levelLoseScreenTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        GameWindow gw = new GameWindow(ge, 600,400);
        Player player = new Player();
        List<Entity> list = new ArrayList<>();
        list.add(player);
        LevelImpl level = new LevelImpl(600,380, player, list);
        level.loseScreen();
    }
    @Test
    public void levelIntersectTest2(){
        Player player = new Player();
        player.setXPos(30);
        player.setXPos(30);
        player.setHeight(10);
        player.setWidth(10);
        Slime slime = new Slime();
        slime.setXPos(30);
        slime.setYPos(30);
        slime.setHeight(10);
        slime.setWidth(10);
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        entities.add(slime);
        LevelImpl level = new LevelImpl(600,380, player, entities);

        level.checkIntersect(player, slime);
    }
    @Test
    public void levelTickTest(){
        Player player = new Player();
        player.setWidth(10);
        player.setHeight(10);
        player.setXPos(10);
        player.setYPos(10);

        Slime slime = new Slime();
        slime.setWidth(10);
        slime.setHeight(10);
        slime.setXPos(10);
        slime.setYPos(10);

        Platform p = new Platform();
        p.setHeight(10);
        p.setWidth(10);
        p.setXPos(10);
        p.setYPos(10);

        FinishLine f = new FinishLine();
        f.setHeight(10);
        f.setWidth(10);
        f.setXPos(10);
        f.setYPos(10);

        Coin coin = new Coin();
        coin.setHeight(10);
        coin.setWidth(10);
        coin.setXPos(10);
        coin.setYPos(10);

        List<Entity> list = new ArrayList<>();
        list.add(player);
        list.add(slime);
        list.add(p);
        list.add(f);
        list.add(coin);

        LevelImpl level = new LevelImpl(600,400, player, list);
        level.tick();
    }


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
        Entity.Layer layer = p.getLayer();
        assertEquals(Entity.Layer.BACKGROUND, layer);
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
        Entity.Layer layer = slime.getLayer();
        assertEquals(Entity.Layer.FOREGROUND, layer);
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
        Entity.Layer layer = tree.getLayer();
        assertEquals(Entity.Layer.BACKGROUND, layer);
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

    //GameWindow/////////////////////////////////////////////////////////////
    @Test
    public void gameWindowSceneTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        GameWindow gw = new GameWindow(ge, 600, 400);
        Scene scene = gw.getScene();

    }
    @Test
    public void gameWindowPaneTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        GameWindow gw = new GameWindow(ge, 600, 400);
        Pane palen = gw.getPane();

    }
    @Test
    public void gameWindowRunTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        GameWindow gw = new GameWindow(ge, 600, 400);
        gw.run();
    }

    //ParallaxBackground//////////////////////////////////////////////////////////////////////////
    @Test
    public void pbDrawTest(){
        ParallaxBackground pb = new ParallaxBackground();
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        Pane pane = new Pane();
        pb.draw(ge, pane);
    }
    //BlockedBackground/////////////////////////////////////////////////////////////////////
    @Test
    public void bbDrawTest(){
        BlockedBackground bb = new BlockedBackground();
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        Pane pane = new Pane();
        bb.draw(ge, pane);
    }

    //KeyboardHandler//////////////////////////////////////////////////////////////
    @Test
    public void keyboardTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
    }
    @Test
    public void keyboardPressLeftTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent left = new KeyEvent( KeyEvent.KEY_PRESSED, KeyCode.LEFT.toString(), KeyCode.LEFT.toString(), KeyCode.LEFT, false,
                false, false, false);
        kb.handlePressed(left);
    }
    @Test
    public void keyboardPressRightTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent right = new KeyEvent( KeyEvent.KEY_PRESSED, KeyCode.RIGHT.toString(), KeyCode.RIGHT.toString(), KeyCode.RIGHT, false,
                false, false, false);
        kb.handlePressed(right);
    }
    @Test
    public void keyboardPressUpTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent up = new KeyEvent( KeyEvent.KEY_PRESSED, KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false,
                false, false, false);
        kb.handlePressed(up);
    }
    @Test
    public void keyboardReleaseUpTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent up = new KeyEvent( KeyEvent.KEY_RELEASED, KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false,
                false, false, false);
        kb.handleReleased(up);
    }
    @Test
    public void keyboardReleaseLeftTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent left = new KeyEvent( KeyEvent.KEY_RELEASED, KeyCode.LEFT.toString(), KeyCode.LEFT.toString(), KeyCode.LEFT, false,
                false, false, false);
        kb.handleReleased(left);
    }
    @Test
    public void keyboardReleaseRightTest(){
        GameEngine ge = new GameEngineImpl("src\\main\\resources\\default.json");
        KeyboardInputHandler kb = new KeyboardInputHandler(ge);
        KeyEvent right = new KeyEvent( KeyEvent.KEY_RELEASED, KeyCode.RIGHT.toString(), KeyCode.RIGHT.toString(), KeyCode.RIGHT, false,
                false, false, false);
        kb.handleReleased(right);
    }





}
