package stickman.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.model.GameEngine;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle floor;
    private Pane pane;
    private GameEngine model;

    @Override
    public void draw(GameEngine model, Pane pane) {
        this.model = model;
        this.pane = pane;
        double width = pane.getWidth();
        double height = pane.getHeight();
        double floorHeight = model.getCurrentLevel().getFloorHeight();

        createSky(width, floorHeight);
        createFloor(height, width, floorHeight);
    }

    @Override
    public void update(double xViewportOffset) {
        // do nothing since this is a static bg
    }

    /**
     * Creates the sky for the Game
     * @param width The width of the sky (Also the width of the window) in pixels.
     * @param floorHeight The height of the floor in pixels.
     */
    public void createSky(double width, double floorHeight){

        this.sky = new Rectangle(0, 0, width, floorHeight);
        sky.setFill(Paint.valueOf("LIGHTBLUE"));
        sky.setViewOrder(1000.0);
        pane.getChildren().add(sky);
    }

    /**
     * Creates the floor for the Game window
     * @param height The height of the pane in pixels.
     * @param width The width of the pane in pixels.
     * @param floorHeight The height of the floor in pixels.
     */
    private void createFloor(double height, double width, double floorHeight){

        this.floor = new Rectangle(0, floorHeight, width, height - floorHeight);
        floor.setFill(Paint.valueOf("GREEN"));
        floor.setViewOrder(1000.0);
        pane.getChildren().add(floor);
    }
}
