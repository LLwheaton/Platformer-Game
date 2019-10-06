package stickman.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import stickman.model.Entity;
import stickman.model.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class GameWindow {
    private final int width;
    private Scene scene;
    private Pane pane;
    private GameEngine model;
    private List<EntityView> entityViews;
    private BackgroundDrawer backgroundDrawer;

    private double xViewportOffset = 0.0;
    private static final double VIEWPORT_MARGIN = 280.0;

    public static Pane originalPane;

    public GameWindow(GameEngine model, int width, int height) {
        this.model = model;
        this.pane = new Pane();
        this.width = width;
        this.scene = new Scene(pane, width, height);

        originalPane = this.pane;

        this.entityViews = new ArrayList<>();

        KeyboardInputHandler keyboardInputHandler = new KeyboardInputHandler(model);

        scene.setOnKeyPressed(keyboardInputHandler::handlePressed);
        scene.setOnKeyReleased(keyboardInputHandler::handleReleased);

        //this.backgroundDrawer = new BlockedBackground();
        //this.backgroundDrawer = new ParallaxBackground();
        this.backgroundDrawer = new MagicBackground();

        backgroundDrawer.draw(model, pane);
    }

    public static Pane getPane(){
        return originalPane;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void draw() {
        model.tick();

        List<Entity> entities = model.getCurrentLevel().getEntities();

        for (EntityView entityView: entityViews) {
            entityView.markForDelete();
        }

        viewportAction();
        handleEntityViews(entities);

        for (EntityView entityView: entityViews) {
            if (entityView.isMarkedForDelete()) {
                pane.getChildren().remove(entityView.getNode());
            }
        }
        entityViews.removeIf(EntityView::isMarkedForDelete);
    }

    public void viewportAction(){
        double heroXPos = model.getCurrentLevel().getHeroX();
        heroXPos -= xViewportOffset;

        if (heroXPos < VIEWPORT_MARGIN) {
            if (xViewportOffset >= 0) { // Don't go further left than the start of the level
                xViewportOffset -= VIEWPORT_MARGIN - heroXPos;
                if (xViewportOffset < 0) {
                    xViewportOffset = 0;
                }
            }
        } else if (heroXPos > width - VIEWPORT_MARGIN) {
            xViewportOffset += heroXPos - (width - VIEWPORT_MARGIN);
        }

        backgroundDrawer.update(xViewportOffset);
    }

    public void handleEntityViews(List<Entity> entities){
        for (Entity entity: entities) {
            boolean notFound = true;
            for (EntityView view: entityViews) {
                if (view.matchesEntity(entity)) {
                    notFound = false;
                    view.update(xViewportOffset);
                    break;
                }
            }
            if (notFound) {
                EntityView entityView = new EntityViewImpl(entity);
                entityViews.add(entityView);
                pane.getChildren().add(entityView.getNode());
            }
        }
    }

}
